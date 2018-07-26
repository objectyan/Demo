package com.baidu.navi.adapter;

import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.carlife.C0965R;
import com.baidu.carlife.CarlifeActivity;
import com.baidu.navi.fragment.NaviFragmentManager;
import com.baidu.navi.style.StyleManager;
import com.baidu.navi.utils.CharacterParser;
import com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager;
import com.baidu.navisdk.comapi.poisearch.BNPoiSearcher;
import com.baidu.navisdk.model.GeoLocateModel;
import com.baidu.navisdk.model.datastruct.DistrictInfo;
import com.baidu.navisdk.util.common.LogUtil;
import java.text.Collator;
import java.text.RuleBasedCollator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;

public class DistrictAdapter extends BaseExpandableListAdapter {
    public static final String CURRENT_LOCATION = "current";
    public static final String OTHER_LOCATION = "other";
    private static final String TAG = "DistrictAdapter";
    private static final int TOP_LAST_ITEM = 1;
    Drawable dividerDrawable;
    ArrayList<GroupDataHolder> groupDataList;
    private InitWordBookTask initWordBookTask = new InitWordBookTask();
    private boolean isMapMode = true;
    CarlifeActivity mActivity;
    private HashMap<String, WordBook> mWordBook;
    private ArrayList<Integer> positionIdRelation = new ArrayList();
    int textColorList;
    int textColorTitle;

    public class ChildDataHolder {
        public String abbreviation;
        public int childPosition;
        public int groupPosition;
        public int id;
        public String name;
        public String pinyin;
    }

    public class DistrictComparator implements Comparator<DistrictInfo> {
        RuleBasedCollator chinese_cmp = ((RuleBasedCollator) Collator.getInstance(Locale.CHINA));

        public int compare(DistrictInfo lhs, DistrictInfo rhs) {
            String lstr = lhs.mName;
            String rstr = rhs.mName;
            if (lstr.equals("重庆市")) {
                lstr = "宠庆市";
            }
            if (rstr.equals("重庆市")) {
                rstr = "宠庆市";
            }
            if (lstr.equals("长春市")) {
                lstr = "常春市";
            }
            if (rstr.equals("长春市")) {
                rstr = "常春市";
            }
            if (lstr.equals("长治市")) {
                lstr = "常治市";
            }
            if (rstr.equals("长治市")) {
                rstr = "常治市";
            }
            return this.chinese_cmp.compare(lstr, rstr);
        }
    }

    public class GroupDataHolder {
        public boolean alreadyDownload = false;
        public ArrayList<ChildDataHolder> childList;
        public int id = -1;
        public int listType = 0;
        public String name = "province";
    }

    private class InitWordBookTask extends AsyncTask<Integer, Integer, Integer> {
        private InitWordBookTask() {
        }

        protected Integer doInBackground(Integer... params) {
            if (DistrictAdapter.this.mWordBook == null) {
                LogUtil.m15791e(DistrictAdapter.TAG, "mWordBook == null");
                DistrictAdapter.this.mWordBook = DistrictAdapter.this.initWordBook();
            }
            return null;
        }
    }

    public class WordBook {
        public ArrayList<Integer> cachePosition;
        public int childPosition = 0;
        public int groupPosition = 0;
        public HashMap<String, WordBook> nextMap;
    }

    public DistrictAdapter(CarlifeActivity activity) {
        this.mActivity = activity;
        this.isMapMode = NaviFragmentManager.isUsingMapMode();
        initResource();
        this.groupDataList = new ArrayList();
        updateGroupList();
        specialDealWithProvince();
        this.initWordBookTask.execute(new Integer[]{Integer.valueOf(1)});
        this.initWordBookTask = null;
    }

    public void initResource() {
        this.textColorTitle = StyleManager.getColor(C0965R.color.bnav_common_text_color_title);
        this.textColorList = StyleManager.getColor(C0965R.color.common_list_main_text_color);
        this.dividerDrawable = StyleManager.getDrawable(C0965R.drawable.divide_list);
    }

    private void specialDealWithProvince() {
        Iterator it = this.groupDataList.iterator();
        while (it.hasNext()) {
            GroupDataHolder provinceInfo = (GroupDataHolder) it.next();
            if (provinceInfo.name.equals("澳门特别行政区")) {
                provinceInfo.name = "澳门";
            }
            if (provinceInfo.name.equals("香港特别行政区")) {
                provinceInfo.name = "香港";
            }
            if (provinceInfo.name.equals("北京市")) {
                provinceInfo.name = "北京";
            }
            if (provinceInfo.name.equals("重庆市")) {
                provinceInfo.name = "重庆";
            }
            if (provinceInfo.name.equals("上海市")) {
                provinceInfo.name = "上海";
            }
            if (provinceInfo.name.equals("天津市")) {
                provinceInfo.name = "天津";
            }
            if (provinceInfo.name.equals("广西壮族自治区")) {
                provinceInfo.name = "广西";
            }
            if (provinceInfo.name.equals("内蒙古自治区")) {
                provinceInfo.name = "内蒙古";
            }
            if (provinceInfo.name.equals("宁夏回族自治区")) {
                provinceInfo.name = "宁夏";
            }
            if (provinceInfo.name.equals("青海省")) {
                provinceInfo.name = "青海";
            }
            if (provinceInfo.name.equals("西藏自治区")) {
                provinceInfo.name = "西藏";
            }
            if (provinceInfo.name.equals("新疆维吾尔自治区")) {
                provinceInfo.name = "新疆";
            }
        }
    }

    public Object getGroup(int groupPosition) {
        if (groupPosition >= this.groupDataList.size()) {
            return null;
        }
        return this.groupDataList.get(groupPosition);
    }

    public Object getChild(int groupPosition, int childPosition) {
        GroupDataHolder groupHolder = (GroupDataHolder) getGroup(groupPosition);
        if (groupHolder == null || groupHolder.childList == null || childPosition < 0 || childPosition >= groupHolder.childList.size()) {
            return null;
        }
        return (ChildDataHolder) groupHolder.childList.get(childPosition);
    }

    public long getGroupId(int groupPosition) {
        GroupDataHolder holder = (GroupDataHolder) getGroup(groupPosition);
        if (holder == null) {
            return -1;
        }
        return (long) holder.id;
    }

    public long getChildId(int groupPosition, int childPosition) {
        return (long) ((ChildDataHolder) getChild(groupPosition, childPosition)).id;
    }

    public int getGroupCount() {
        return this.groupDataList.size();
    }

    public int getChildrenCount(int groupPosition) {
        GroupDataHolder groupHolder = (GroupDataHolder) getGroup(groupPosition);
        if (groupHolder == null || groupHolder.name.equals("other") || groupHolder.name.equals(CURRENT_LOCATION) || groupHolder.listType == 1) {
            return -1;
        }
        if (groupHolder.childList == null) {
            ArrayList<DistrictInfo> cityCheckList = new ArrayList();
            BNPoiSearcher.getInstance().getChildDistrict(groupHolder.id, cityCheckList);
            BNPoiSearcher.getInstance().getDistrictById(((GroupDataHolder) getGroup(groupPosition)).id).mName = "全省";
            if (cityCheckList.size() > 1) {
                Collections.sort(cityCheckList, new DistrictComparator());
            }
            groupHolder.childList = initCityPositionList(groupHolder.id, groupPosition, cityCheckList);
        }
        if (groupHolder.childList.size() != 1) {
            return groupHolder.childList.size();
        }
        return -1;
    }

    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        GroupDataHolder groupHolder = (GroupDataHolder) getGroup(groupPosition);
        TextView tv;
        View divider;
        if (groupHolder.name.equals(CURRENT_LOCATION)) {
            convertView = (LinearLayout) LayoutInflater.from(this.mActivity).inflate(C0965R.layout.search_district_group_list_divide_item, null);
            tv = (TextView) convertView.findViewById(C0965R.id.tv_search_district_head_item);
            tv.setText(C0965R.string.search_district_current_district);
            divider = convertView.findViewById(C0965R.id.list_item_divider);
            tv.setTextColor(this.textColorTitle);
            divider.setBackgroundDrawable(this.dividerDrawable);
            convertView.setBackgroundColor(StyleManager.getColor(C0965R.color.bnav_common_bg_title));
            convertView.setTag(null);
            return convertView;
        } else if (groupHolder.name.equals("other")) {
            convertView = (LinearLayout) LayoutInflater.from(this.mActivity).inflate(C0965R.layout.search_district_group_list_divide_item, null);
            tv = (TextView) convertView.findViewById(C0965R.id.tv_search_district_head_item);
            tv.setText(C0965R.string.search_district_all_district);
            divider = convertView.findViewById(C0965R.id.list_item_divider);
            tv.setTextColor(this.textColorTitle);
            divider.setBackgroundDrawable(this.dividerDrawable);
            convertView.setBackgroundColor(StyleManager.getColor(C0965R.color.bnav_common_bg_title));
            convertView.setTag(null);
            return convertView;
        } else {
            View view = getGenericGroupView(convertView, groupPosition, groupHolder.name);
            if (groupHolder.name.equals("北京") || groupHolder.name.equals("上海") || groupHolder.name.equals("重庆") || groupHolder.name.equals("天津") || groupHolder.name.equals("澳门") || groupHolder.name.equals("香港")) {
                setGroupViewStyle(view, groupPosition, isExpanded, false, groupHolder.alreadyDownload);
                return view;
            }
            setGroupViewStyle(view, groupPosition, isExpanded, true, groupHolder.alreadyDownload);
            return view;
        }
    }

    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        convertView = getGenericChildView(convertView, ((ChildDataHolder) getChild(groupPosition, childPosition)).name);
        setChildViewStyle(convertView, groupPosition, childPosition);
        return convertView;
    }

    public boolean hasStableIds() {
        return true;
    }

    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    private View getGenericGroupView(View convertView, int groupPosition, String name) {
        LayoutInflater inflater = LayoutInflater.from(this.mActivity);
        int flag = 0;
        if (convertView == null || convertView.getTag() == null) {
            if (this.isMapMode) {
                convertView = inflater.inflate(C0965R.layout.search_district_group_list_item, null);
                flag = 1;
            } else {
                convertView = inflater.inflate(C0965R.layout.carmode_search_district_group, null);
                flag = 2;
            }
        } else if (!(this.isMapMode || ((Integer) convertView.getTag()).intValue() == 2)) {
            convertView = inflater.inflate(C0965R.layout.carmode_search_district_group, null);
            flag = 2;
        }
        if (convertView == null) {
            return null;
        }
        convertView.setTag(Integer.valueOf(flag));
        TextView catalogTV = (TextView) convertView.findViewById(C0965R.id.catalog_tv);
        if (catalogTV == null) {
            return convertView;
        }
        catalogTV.setText(name);
        if (!this.isMapMode) {
            return convertView;
        }
        catalogTV.setTextColor(this.textColorList);
        return convertView;
    }

    private void setGroupViewStyle(View view, int groupPosition, boolean isExpanded, boolean canExpand, boolean alreadDownload) {
        if (view != null) {
            View divider = view.findViewById(C0965R.id.list_item_divider);
            ImageView eclipseIV = (ImageView) view.findViewById(C0965R.id.eclipse_iv);
            View isCurrentCity = view.findViewById(C0965R.id.is_current_city);
            if (groupPosition != getGroupCount() - 1) {
                GroupDataHolder groupDataHolder = new GroupDataHolder();
                if (((GroupDataHolder) getGroup(groupPosition)).listType == 1) {
                    eclipseIV.setVisibility(8);
                    if (isCurrentCity != null) {
                        isCurrentCity.setVisibility(0);
                    }
                } else {
                    eclipseIV.setVisibility(0);
                    if (isCurrentCity != null) {
                        isCurrentCity.setVisibility(8);
                    }
                }
            }
            if (eclipseIV != null) {
                if (isExpanded) {
                    eclipseIV.setImageDrawable(this.isMapMode ? StyleManager.getDrawable(C0965R.drawable.ic_list_eclipse_up) : StyleManager.getDrawable(C0965R.drawable.carmode_ic_list_eclipse_up));
                } else {
                    eclipseIV.setImageDrawable(this.isMapMode ? StyleManager.getDrawable(C0965R.drawable.ic_list_eclipse_down) : StyleManager.getDrawable(C0965R.drawable.carmode_ic_list_eclipse_down));
                }
            }
            View downloaded = view.findViewById(C0965R.id.already_download);
            if (alreadDownload) {
                downloaded.setVisibility(0);
            } else {
                downloaded.setVisibility(8);
            }
            if (this.isMapMode) {
                divider.setBackgroundDrawable(this.dividerDrawable);
                view.setBackgroundDrawable(StyleManager.getDrawable(C0965R.drawable.common_list_bg_selector));
            }
        }
    }

    private View getGenericChildView(View convertView, String name) {
        LayoutInflater inflater = LayoutInflater.from(this.mActivity);
        int flag = 0;
        if (convertView == null) {
            int resId;
            if (this.isMapMode) {
                resId = C0965R.layout.search_district_child_list_item;
                flag = 1;
            } else {
                resId = C0965R.layout.carmode_search_district_child;
                flag = 2;
            }
            convertView = inflater.inflate(resId, null);
            if (convertView == null) {
                return null;
            }
        } else if (!(this.isMapMode || ((Integer) convertView.getTag()).intValue() == 2)) {
            convertView = inflater.inflate(C0965R.layout.carmode_search_district_child, null);
            flag = 2;
        }
        if (convertView == null) {
            return null;
        }
        convertView.setTag(Integer.valueOf(flag));
        TextView catalogTV = (TextView) convertView.findViewById(C0965R.id.catalog_child_tv);
        if (catalogTV != null) {
            catalogTV.setText(name);
            if (this.isMapMode) {
                catalogTV.setTextColor(this.textColorList);
            }
        }
        return convertView;
    }

    private void setChildViewStyle(View view, int groupPosition, int childPosition) {
        if (view != null) {
            View divider = view.findViewById(C0965R.id.list_item_divider);
            if (this.isMapMode) {
                divider.setBackgroundDrawable(this.dividerDrawable);
                view.setBackgroundDrawable(StyleManager.getDrawable(C0965R.drawable.common_list_child_bg_selector));
            }
        }
    }

    private ArrayList<ChildDataHolder> initCityPositionList(int provinceId, int groupPosition, ArrayList<DistrictInfo> cityCheckList) {
        ArrayList<ChildDataHolder> cityPositionList = new ArrayList();
        int listSize = cityCheckList.size();
        for (int i = 0; i < listSize; i++) {
            ChildDataHolder childHolder = new ChildDataHolder();
            DistrictInfo tempInfo = (DistrictInfo) cityCheckList.get(i);
            StringBuilder sb = new StringBuilder();
            childHolder.name = tempInfo.mName;
            String tmpName = tempInfo.mName;
            if (tmpName.equals("重庆市")) {
                childHolder.pinyin = CharacterParser.getAbbreviation("chongqingshi", sb);
            } else {
                childHolder.pinyin = CharacterParser.getAbbreviation(tmpName, sb);
            }
            childHolder.abbreviation = sb.toString();
            childHolder.id = ((provinceId << 16) & -65536) | (tempInfo.mId & 65535);
            childHolder.groupPosition = groupPosition;
            childHolder.childPosition = i;
            cityPositionList.add(childHolder);
        }
        return cityPositionList;
    }

    public void updateGroupList() {
        GroupDataHolder downHolder;
        ArrayList<DistrictInfo> provinceCheckList = new ArrayList();
        ArrayList<DistrictInfo> downProvinceList = new ArrayList();
        ArrayList<DistrictInfo> notProvinceList = new ArrayList();
        DistrictInfo currentCity = GeoLocateModel.getInstance().getCurrentDistrict();
        DistrictInfo parentDistrict = GeoLocateModel.getInstance().getProvinceDistrict();
        boolean isCurrentAvailable = GeoLocateModel.getInstance().hasUpdateDistrictInfo();
        BNPoiSearcher.getInstance().getChildDistrict(0, provinceCheckList);
        Iterator it = provinceCheckList.iterator();
        while (it.hasNext()) {
            DistrictInfo info = (DistrictInfo) it.next();
            if (BNOfflineDataManager.getInstance().isProvinceDataDownload(info.mId)) {
                downProvinceList.add(info);
            } else {
                notProvinceList.add(info);
            }
        }
        DistrictComparator comparator = new DistrictComparator();
        Collections.sort(downProvinceList, comparator);
        Collections.sort(notProvinceList, comparator);
        if (isCurrentAvailable && currentCity != null) {
            if (this.isMapMode) {
                GroupDataHolder downHindHolder = new GroupDataHolder();
                downHindHolder.name = CURRENT_LOCATION;
                this.groupDataList.add(downHindHolder);
                this.positionIdRelation.add(Integer.valueOf(0));
            }
            downHolder = new GroupDataHolder();
            downHolder.id = currentCity.mId;
            downHolder.name = currentCity.mName;
            if (parentDistrict != null && BNOfflineDataManager.getInstance().isProvinceDataDownload(parentDistrict.mId)) {
                downHolder.alreadyDownload = true;
            }
            this.groupDataList.add(downHolder);
            downHolder.listType = 1;
            this.positionIdRelation.add(Integer.valueOf(currentCity.mId));
        }
        if (this.isMapMode) {
            downHindHolder = new GroupDataHolder();
            downHindHolder.name = "other";
            this.groupDataList.add(downHindHolder);
            this.positionIdRelation.add(Integer.valueOf(0));
        }
        if (downProvinceList.size() > 0) {
            it = downProvinceList.iterator();
            while (it.hasNext()) {
                info = (DistrictInfo) it.next();
                downHolder = new GroupDataHolder();
                downHolder.id = info.mId;
                downHolder.name = info.mName;
                downHolder.alreadyDownload = true;
                this.groupDataList.add(downHolder);
                this.positionIdRelation.add(Integer.valueOf(info.mId));
            }
        }
        if (notProvinceList.size() > 0) {
            it = notProvinceList.iterator();
            while (it.hasNext()) {
                info = (DistrictInfo) it.next();
                GroupDataHolder notHolder = new GroupDataHolder();
                notHolder.id = info.mId;
                notHolder.name = info.mName;
                this.groupDataList.add(notHolder);
                this.positionIdRelation.add(Integer.valueOf(info.mId));
            }
        }
    }

    public int getListPositionById(int id) {
        return this.positionIdRelation.indexOf(Integer.valueOf(id));
    }

    private HashMap<String, WordBook> initWordBook() {
        HashMap<String, WordBook> wordBook = new HashMap();
        int groupCount = getGroupCount();
        for (int i = 0; i < groupCount && true; i++) {
            int childrenCount = getChildrenCount(i);
            GroupDataHolder groupHolder = (GroupDataHolder) getGroup(i);
            ArrayList<ChildDataHolder> childList = groupHolder.childList;
            if (childList == null) {
                getChildrenCount(i);
                childList = groupHolder.childList;
            }
            for (int j = 0; j < childrenCount; j++) {
                ChildDataHolder childData = (ChildDataHolder) childList.get(j);
                if (childData == null) {
                    break;
                }
                int k;
                HashMap<String, WordBook> rootMap = wordBook;
                WordBook tmpBook = null;
                int length = childData.abbreviation.length();
                for (k = 0; k < length; k++) {
                    ArrayList<Integer> cachePosition;
                    String tmpChar = String.valueOf(childData.abbreviation.charAt(k));
                    if (rootMap == null && tmpBook != null) {
                        tmpBook.nextMap = new HashMap();
                        rootMap = tmpBook.nextMap;
                    }
                    tmpBook = (WordBook) rootMap.get(tmpChar);
                    if (tmpBook == null) {
                        tmpBook = new WordBook();
                        tmpBook.groupPosition = i;
                        tmpBook.childPosition = j;
                        rootMap.put(tmpChar, tmpBook);
                    } else {
                        cachePosition = tmpBook.cachePosition;
                        if (cachePosition == null) {
                            tmpBook.cachePosition = new ArrayList();
                            cachePosition = tmpBook.cachePosition;
                            cachePosition.add(Integer.valueOf((tmpBook.groupPosition << 8) + tmpBook.childPosition));
                        }
                        cachePosition.add(Integer.valueOf((i * 100) + j));
                        if (k == length - 1) {
                            tmpBook.groupPosition = i;
                            tmpBook.childPosition = j;
                        }
                    }
                    rootMap = tmpBook.nextMap;
                }
                rootMap = wordBook;
                length = childData.pinyin.length();
                for (k = 0; k < length; k++) {
                    tmpChar = String.valueOf(childData.pinyin.charAt(k));
                    if (rootMap == null && tmpBook != null) {
                        tmpBook.nextMap = new HashMap();
                        rootMap = tmpBook.nextMap;
                    }
                    tmpBook = (WordBook) rootMap.get(tmpChar);
                    if (tmpBook == null) {
                        tmpBook = new WordBook();
                        tmpBook.groupPosition = i;
                        tmpBook.childPosition = j;
                        rootMap.put(tmpChar, tmpBook);
                    } else {
                        cachePosition = tmpBook.cachePosition;
                        if (cachePosition == null) {
                            tmpBook.cachePosition = new ArrayList();
                            cachePosition = tmpBook.cachePosition;
                            cachePosition.add(Integer.valueOf((tmpBook.groupPosition << 8) + tmpBook.childPosition));
                        }
                        cachePosition.add(Integer.valueOf((i * 100) + j));
                        if (k == length - 1) {
                            tmpBook.groupPosition = i;
                            tmpBook.childPosition = j;
                        }
                    }
                    rootMap = tmpBook.nextMap;
                }
            }
        }
        return wordBook;
    }

    public WordBook searchCityByAbbreviation(String searchKey) {
        HashMap<String, WordBook> rootMap = this.mWordBook;
        WordBook currentWord = null;
        for (int i = 0; i < searchKey.length(); i++) {
            if (rootMap == null) {
                return null;
            }
            currentWord = (WordBook) rootMap.get(String.valueOf(searchKey.charAt(i)));
            if (currentWord == null) {
                return null;
            }
            rootMap = currentWord.nextMap;
        }
        return currentWord;
    }
}
