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
import java.util.List;
import java.util.Locale;

public class DistrictAdapter
  extends BaseExpandableListAdapter
{
  public static final String CURRENT_LOCATION = "current";
  public static final String OTHER_LOCATION = "other";
  private static final String TAG = "DistrictAdapter";
  private static final int TOP_LAST_ITEM = 1;
  Drawable dividerDrawable;
  ArrayList<GroupDataHolder> groupDataList;
  private InitWordBookTask initWordBookTask = new InitWordBookTask(null);
  private boolean isMapMode = true;
  CarlifeActivity mActivity;
  private HashMap<String, WordBook> mWordBook;
  private ArrayList<Integer> positionIdRelation = new ArrayList();
  int textColorList;
  int textColorTitle;
  
  public DistrictAdapter(CarlifeActivity paramCarlifeActivity)
  {
    this.mActivity = paramCarlifeActivity;
    this.isMapMode = NaviFragmentManager.isUsingMapMode();
    initResource();
    this.groupDataList = new ArrayList();
    updateGroupList();
    specialDealWithProvince();
    this.initWordBookTask.execute(new Integer[] { Integer.valueOf(1) });
    this.initWordBookTask = null;
  }
  
  private View getGenericChildView(View paramView, String paramString)
  {
    LayoutInflater localLayoutInflater = LayoutInflater.from(this.mActivity);
    int j = 0;
    if (paramView == null)
    {
      if (this.isMapMode) {
        j = 2130969008;
      }
      for (i = 1;; i = 2)
      {
        paramView = localLayoutInflater.inflate(j, null);
        localView = paramView;
        if (paramView != null) {
          break;
        }
        return null;
        j = 2130968686;
      }
    }
    int i = j;
    View localView = paramView;
    if (!this.isMapMode)
    {
      i = j;
      localView = paramView;
      if (((Integer)paramView.getTag()).intValue() != 2)
      {
        localView = localLayoutInflater.inflate(2130968686, null);
        i = 2;
      }
    }
    if (localView == null) {
      return null;
    }
    localView.setTag(Integer.valueOf(i));
    paramView = (TextView)localView.findViewById(2131624596);
    if (paramView != null)
    {
      paramView.setText(paramString);
      if (this.isMapMode) {
        paramView.setTextColor(this.textColorList);
      }
    }
    return localView;
  }
  
  private View getGenericGroupView(View paramView, int paramInt, String paramString)
  {
    Object localObject = LayoutInflater.from(this.mActivity);
    int i = 0;
    View localView;
    if ((paramView == null) || (paramView.getTag() == null)) {
      if (this.isMapMode)
      {
        localView = ((LayoutInflater)localObject).inflate(2130969010, null);
        paramInt = 1;
        if (localView != null) {
          break label114;
        }
        paramView = null;
      }
    }
    label114:
    do
    {
      do
      {
        return paramView;
        localView = ((LayoutInflater)localObject).inflate(2130968687, null);
        paramInt = 2;
        break;
        paramInt = i;
        localView = paramView;
        if (this.isMapMode) {
          break;
        }
        paramInt = i;
        localView = paramView;
        if (((Integer)paramView.getTag()).intValue() == 2) {
          break;
        }
        localView = ((LayoutInflater)localObject).inflate(2130968687, null);
        paramInt = 2;
        break;
        localView.setTag(Integer.valueOf(paramInt));
        localObject = (TextView)localView.findViewById(2131624282);
        paramView = localView;
      } while (localObject == null);
      ((TextView)localObject).setText(paramString);
      paramView = localView;
    } while (!this.isMapMode);
    ((TextView)localObject).setTextColor(this.textColorList);
    return localView;
  }
  
  private ArrayList<ChildDataHolder> initCityPositionList(int paramInt1, int paramInt2, ArrayList<DistrictInfo> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    int j = paramArrayList.size();
    int i = 0;
    if (i < j)
    {
      ChildDataHolder localChildDataHolder = new ChildDataHolder();
      DistrictInfo localDistrictInfo = (DistrictInfo)paramArrayList.get(i);
      StringBuilder localStringBuilder = new StringBuilder();
      localChildDataHolder.name = localDistrictInfo.mName;
      String str = localDistrictInfo.mName;
      if (str.equals("重庆市")) {}
      for (localChildDataHolder.pinyin = CharacterParser.getAbbreviation("chongqingshi", localStringBuilder);; localChildDataHolder.pinyin = CharacterParser.getAbbreviation(str, localStringBuilder))
      {
        localChildDataHolder.abbreviation = localStringBuilder.toString();
        localChildDataHolder.id = (paramInt1 << 16 & 0xFFFF0000 | localDistrictInfo.mId & 0xFFFF);
        localChildDataHolder.groupPosition = paramInt2;
        localChildDataHolder.childPosition = i;
        localArrayList.add(localChildDataHolder);
        i += 1;
        break;
      }
    }
    return localArrayList;
  }
  
  private HashMap<String, WordBook> initWordBook()
  {
    HashMap localHashMap = new HashMap();
    int m = getGroupCount();
    int i = 0;
    if ((i < m) && (1 != 0))
    {
      int n = getChildrenCount(i);
      Object localObject2 = (GroupDataHolder)getGroup(i);
      Object localObject1 = ((GroupDataHolder)localObject2).childList;
      Object localObject3 = localObject1;
      if (localObject1 == null)
      {
        getChildrenCount(i);
        localObject3 = ((GroupDataHolder)localObject2).childList;
      }
      int j = 0;
      for (;;)
      {
        ChildDataHolder localChildDataHolder;
        if (j < n)
        {
          localChildDataHolder = (ChildDataHolder)((ArrayList)localObject3).get(j);
          if (localChildDataHolder != null) {}
        }
        else
        {
          i += 1;
          break;
        }
        localObject2 = localHashMap;
        localObject1 = null;
        int i1 = localChildDataHolder.abbreviation.length();
        int k = 0;
        String str;
        if (k < i1)
        {
          str = String.valueOf(localChildDataHolder.abbreviation.charAt(k));
          localObject4 = localObject2;
          if (localObject2 == null)
          {
            localObject4 = localObject2;
            if (localObject1 != null)
            {
              ((WordBook)localObject1).nextMap = new HashMap();
              localObject4 = ((WordBook)localObject1).nextMap;
            }
          }
          localObject2 = (WordBook)((HashMap)localObject4).get(str);
          if (localObject2 == null)
          {
            localObject1 = new WordBook();
            ((WordBook)localObject1).groupPosition = i;
            ((WordBook)localObject1).childPosition = j;
            ((HashMap)localObject4).put(str, localObject1);
          }
          for (;;)
          {
            localObject2 = ((WordBook)localObject1).nextMap;
            k += 1;
            break;
            localObject4 = ((WordBook)localObject2).cachePosition;
            localObject1 = localObject4;
            if (localObject4 == null)
            {
              ((WordBook)localObject2).cachePosition = new ArrayList();
              localObject1 = ((WordBook)localObject2).cachePosition;
              ((ArrayList)localObject1).add(Integer.valueOf((((WordBook)localObject2).groupPosition << 8) + ((WordBook)localObject2).childPosition));
            }
            ((ArrayList)localObject1).add(Integer.valueOf(i * 100 + j));
            localObject1 = localObject2;
            if (k == i1 - 1)
            {
              ((WordBook)localObject2).groupPosition = i;
              ((WordBook)localObject2).childPosition = j;
              localObject1 = localObject2;
            }
          }
        }
        localObject2 = localHashMap;
        i1 = localChildDataHolder.pinyin.length();
        k = 0;
        Object localObject4 = localObject1;
        localObject1 = localObject2;
        if (k < i1)
        {
          str = String.valueOf(localChildDataHolder.pinyin.charAt(k));
          localObject2 = localObject1;
          if (localObject1 == null)
          {
            localObject2 = localObject1;
            if (localObject4 != null)
            {
              ((WordBook)localObject4).nextMap = new HashMap();
              localObject2 = ((WordBook)localObject4).nextMap;
            }
          }
          localObject4 = (WordBook)((HashMap)localObject2).get(str);
          if (localObject4 == null)
          {
            localObject1 = new WordBook();
            ((WordBook)localObject1).groupPosition = i;
            ((WordBook)localObject1).childPosition = j;
            ((HashMap)localObject2).put(str, localObject1);
            localObject2 = localObject1;
          }
          for (;;)
          {
            localObject1 = ((WordBook)localObject2).nextMap;
            k += 1;
            localObject4 = localObject2;
            break;
            localObject2 = ((WordBook)localObject4).cachePosition;
            localObject1 = localObject2;
            if (localObject2 == null)
            {
              ((WordBook)localObject4).cachePosition = new ArrayList();
              localObject1 = ((WordBook)localObject4).cachePosition;
              ((ArrayList)localObject1).add(Integer.valueOf((((WordBook)localObject4).groupPosition << 8) + ((WordBook)localObject4).childPosition));
            }
            ((ArrayList)localObject1).add(Integer.valueOf(i * 100 + j));
            localObject2 = localObject4;
            if (k == i1 - 1)
            {
              ((WordBook)localObject4).groupPosition = i;
              ((WordBook)localObject4).childPosition = j;
              localObject2 = localObject4;
            }
          }
        }
        j += 1;
      }
    }
    return localHashMap;
  }
  
  private void setChildViewStyle(View paramView, int paramInt1, int paramInt2)
  {
    if (paramView == null) {}
    View localView;
    do
    {
      return;
      localView = paramView.findViewById(2131624532);
    } while (!this.isMapMode);
    localView.setBackgroundDrawable(this.dividerDrawable);
    paramView.setBackgroundDrawable(StyleManager.getDrawable(2130838437));
  }
  
  private void setGroupViewStyle(View paramView, int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (paramView == null) {}
    label69:
    label189:
    label200:
    label236:
    label244:
    for (;;)
    {
      return;
      View localView = paramView.findViewById(2131624532);
      ImageView localImageView = (ImageView)paramView.findViewById(2131624598);
      Object localObject = paramView.findViewById(2131624599);
      if (paramInt == getGroupCount() - 1)
      {
        if (localImageView != null)
        {
          if (!paramBoolean1) {
            break label200;
          }
          if (!this.isMapMode) {
            break label189;
          }
          localObject = StyleManager.getDrawable(2130838700);
          localImageView.setImageDrawable((Drawable)localObject);
        }
        localObject = paramView.findViewById(2131624597);
        if (!paramBoolean3) {
          break label236;
        }
        ((View)localObject).setVisibility(0);
      }
      for (;;)
      {
        if (!this.isMapMode) {
          break label244;
        }
        localView.setBackgroundDrawable(this.dividerDrawable);
        paramView.setBackgroundDrawable(StyleManager.getDrawable(2130838435));
        return;
        new GroupDataHolder();
        if (((GroupDataHolder)getGroup(paramInt)).listType == 1)
        {
          localImageView.setVisibility(8);
          if (localObject == null) {
            break;
          }
          ((View)localObject).setVisibility(0);
          break;
        }
        localImageView.setVisibility(0);
        if (localObject == null) {
          break;
        }
        ((View)localObject).setVisibility(8);
        break;
        localObject = StyleManager.getDrawable(2130838126);
        break label69;
        if (this.isMapMode) {}
        for (localObject = StyleManager.getDrawable(2130838699);; localObject = StyleManager.getDrawable(2130838125))
        {
          localImageView.setImageDrawable((Drawable)localObject);
          break;
        }
        ((View)localObject).setVisibility(8);
      }
    }
  }
  
  private void specialDealWithProvince()
  {
    Iterator localIterator = this.groupDataList.iterator();
    while (localIterator.hasNext())
    {
      GroupDataHolder localGroupDataHolder = (GroupDataHolder)localIterator.next();
      if (localGroupDataHolder.name.equals("澳门特别行政区")) {
        localGroupDataHolder.name = "澳门";
      }
      if (localGroupDataHolder.name.equals("香港特别行政区")) {
        localGroupDataHolder.name = "香港";
      }
      if (localGroupDataHolder.name.equals("北京市")) {
        localGroupDataHolder.name = "北京";
      }
      if (localGroupDataHolder.name.equals("重庆市")) {
        localGroupDataHolder.name = "重庆";
      }
      if (localGroupDataHolder.name.equals("上海市")) {
        localGroupDataHolder.name = "上海";
      }
      if (localGroupDataHolder.name.equals("天津市")) {
        localGroupDataHolder.name = "天津";
      }
      if (localGroupDataHolder.name.equals("广西壮族自治区")) {
        localGroupDataHolder.name = "广西";
      }
      if (localGroupDataHolder.name.equals("内蒙古自治区")) {
        localGroupDataHolder.name = "内蒙古";
      }
      if (localGroupDataHolder.name.equals("宁夏回族自治区")) {
        localGroupDataHolder.name = "宁夏";
      }
      if (localGroupDataHolder.name.equals("青海省")) {
        localGroupDataHolder.name = "青海";
      }
      if (localGroupDataHolder.name.equals("西藏自治区")) {
        localGroupDataHolder.name = "西藏";
      }
      if (localGroupDataHolder.name.equals("新疆维吾尔自治区")) {
        localGroupDataHolder.name = "新疆";
      }
    }
  }
  
  public Object getChild(int paramInt1, int paramInt2)
  {
    GroupDataHolder localGroupDataHolder = (GroupDataHolder)getGroup(paramInt1);
    if ((localGroupDataHolder != null) && (localGroupDataHolder.childList != null) && (paramInt2 >= 0) && (paramInt2 < localGroupDataHolder.childList.size())) {
      return (ChildDataHolder)localGroupDataHolder.childList.get(paramInt2);
    }
    return null;
  }
  
  public long getChildId(int paramInt1, int paramInt2)
  {
    return ((ChildDataHolder)getChild(paramInt1, paramInt2)).id;
  }
  
  public View getChildView(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    paramView = getGenericChildView(paramView, ((ChildDataHolder)getChild(paramInt1, paramInt2)).name);
    setChildViewStyle(paramView, paramInt1, paramInt2);
    return paramView;
  }
  
  public int getChildrenCount(int paramInt)
  {
    GroupDataHolder localGroupDataHolder1 = (GroupDataHolder)getGroup(paramInt);
    if ((localGroupDataHolder1 == null) || (localGroupDataHolder1.name.equals("other")) || (localGroupDataHolder1.name.equals("current")) || (localGroupDataHolder1.listType == 1)) {}
    do
    {
      return -1;
      if (localGroupDataHolder1.childList == null)
      {
        ArrayList localArrayList = new ArrayList();
        BNPoiSearcher.getInstance().getChildDistrict(localGroupDataHolder1.id, localArrayList);
        GroupDataHolder localGroupDataHolder2 = (GroupDataHolder)getGroup(paramInt);
        BNPoiSearcher.getInstance().getDistrictById(localGroupDataHolder2.id).mName = "全省";
        if (localArrayList.size() > 1) {
          Collections.sort(localArrayList, new DistrictComparator());
        }
        localGroupDataHolder1.childList = initCityPositionList(localGroupDataHolder1.id, paramInt, localArrayList);
      }
    } while (localGroupDataHolder1.childList.size() == 1);
    return localGroupDataHolder1.childList.size();
  }
  
  public Object getGroup(int paramInt)
  {
    if (paramInt >= this.groupDataList.size()) {
      return null;
    }
    return this.groupDataList.get(paramInt);
  }
  
  public int getGroupCount()
  {
    return this.groupDataList.size();
  }
  
  public long getGroupId(int paramInt)
  {
    GroupDataHolder localGroupDataHolder = (GroupDataHolder)getGroup(paramInt);
    if (localGroupDataHolder == null) {
      return -1L;
    }
    return localGroupDataHolder.id;
  }
  
  public View getGroupView(int paramInt, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = (GroupDataHolder)getGroup(paramInt);
    View localView;
    if (paramViewGroup.name.equals("current"))
    {
      paramView = (LinearLayout)LayoutInflater.from(this.mActivity).inflate(2130969009, null);
      paramViewGroup = (TextView)paramView.findViewById(2131626049);
      paramViewGroup.setText(2131297125);
      localView = paramView.findViewById(2131624532);
      paramViewGroup.setTextColor(this.textColorTitle);
      localView.setBackgroundDrawable(this.dividerDrawable);
      paramView.setBackgroundColor(StyleManager.getColor(2131558422));
      paramView.setTag(null);
      return paramView;
    }
    if (paramViewGroup.name.equals("other"))
    {
      paramView = (LinearLayout)LayoutInflater.from(this.mActivity).inflate(2130969009, null);
      paramViewGroup = (TextView)paramView.findViewById(2131626049);
      paramViewGroup.setText(2131297124);
      localView = paramView.findViewById(2131624532);
      paramViewGroup.setTextColor(this.textColorTitle);
      localView.setBackgroundDrawable(this.dividerDrawable);
      paramView.setBackgroundColor(StyleManager.getColor(2131558422));
      paramView.setTag(null);
      return paramView;
    }
    paramView = getGenericGroupView(paramView, paramInt, paramViewGroup.name);
    if ((paramViewGroup.name.equals("北京")) || (paramViewGroup.name.equals("上海")) || (paramViewGroup.name.equals("重庆")) || (paramViewGroup.name.equals("天津")) || (paramViewGroup.name.equals("澳门")) || (paramViewGroup.name.equals("香港")))
    {
      setGroupViewStyle(paramView, paramInt, paramBoolean, false, paramViewGroup.alreadyDownload);
      return paramView;
    }
    setGroupViewStyle(paramView, paramInt, paramBoolean, true, paramViewGroup.alreadyDownload);
    return paramView;
  }
  
  public int getListPositionById(int paramInt)
  {
    return this.positionIdRelation.indexOf(Integer.valueOf(paramInt));
  }
  
  public boolean hasStableIds()
  {
    return true;
  }
  
  public void initResource()
  {
    this.textColorTitle = StyleManager.getColor(2131558428);
    this.textColorList = StyleManager.getColor(2131558758);
    this.dividerDrawable = StyleManager.getDrawable(2130838474);
  }
  
  public boolean isChildSelectable(int paramInt1, int paramInt2)
  {
    return true;
  }
  
  public WordBook searchCityByAbbreviation(String paramString)
  {
    HashMap localHashMap = this.mWordBook;
    WordBook localWordBook = null;
    int i = 0;
    while (i < paramString.length())
    {
      if (localHashMap == null) {}
      do
      {
        return null;
        localWordBook = (WordBook)localHashMap.get(String.valueOf(paramString.charAt(i)));
      } while (localWordBook == null);
      localHashMap = localWordBook.nextMap;
      i += 1;
    }
    return localWordBook;
  }
  
  public void updateGroupList()
  {
    Object localObject5 = new ArrayList();
    Object localObject2 = new ArrayList();
    Object localObject1 = new ArrayList();
    Object localObject3 = GeoLocateModel.getInstance().getCurrentDistrict();
    Object localObject4 = GeoLocateModel.getInstance().getProvinceDistrict();
    boolean bool = GeoLocateModel.getInstance().hasUpdateDistrictInfo();
    BNPoiSearcher.getInstance().getChildDistrict(0, (ArrayList)localObject5);
    localObject5 = ((ArrayList)localObject5).iterator();
    while (((Iterator)localObject5).hasNext())
    {
      DistrictInfo localDistrictInfo = (DistrictInfo)((Iterator)localObject5).next();
      if (BNOfflineDataManager.getInstance().isProvinceDataDownload(localDistrictInfo.mId)) {
        ((ArrayList)localObject2).add(localDistrictInfo);
      } else {
        ((ArrayList)localObject1).add(localDistrictInfo);
      }
    }
    localObject5 = new DistrictComparator();
    Collections.sort((List)localObject2, (Comparator)localObject5);
    Collections.sort((List)localObject1, (Comparator)localObject5);
    if ((bool) && (localObject3 != null))
    {
      if (this.isMapMode)
      {
        localObject5 = new GroupDataHolder();
        ((GroupDataHolder)localObject5).name = "current";
        this.groupDataList.add(localObject5);
        this.positionIdRelation.add(Integer.valueOf(0));
      }
      localObject5 = new GroupDataHolder();
      ((GroupDataHolder)localObject5).id = ((DistrictInfo)localObject3).mId;
      ((GroupDataHolder)localObject5).name = ((DistrictInfo)localObject3).mName;
      if ((localObject4 != null) && (BNOfflineDataManager.getInstance().isProvinceDataDownload(((DistrictInfo)localObject4).mId))) {
        ((GroupDataHolder)localObject5).alreadyDownload = true;
      }
      this.groupDataList.add(localObject5);
      ((GroupDataHolder)localObject5).listType = 1;
      this.positionIdRelation.add(Integer.valueOf(((DistrictInfo)localObject3).mId));
    }
    if (this.isMapMode)
    {
      localObject3 = new GroupDataHolder();
      ((GroupDataHolder)localObject3).name = "other";
      this.groupDataList.add(localObject3);
      this.positionIdRelation.add(Integer.valueOf(0));
    }
    if (((ArrayList)localObject2).size() > 0)
    {
      localObject2 = ((ArrayList)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (DistrictInfo)((Iterator)localObject2).next();
        localObject4 = new GroupDataHolder();
        ((GroupDataHolder)localObject4).id = ((DistrictInfo)localObject3).mId;
        ((GroupDataHolder)localObject4).name = ((DistrictInfo)localObject3).mName;
        ((GroupDataHolder)localObject4).alreadyDownload = true;
        this.groupDataList.add(localObject4);
        this.positionIdRelation.add(Integer.valueOf(((DistrictInfo)localObject3).mId));
      }
    }
    if (((ArrayList)localObject1).size() > 0)
    {
      localObject1 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (DistrictInfo)((Iterator)localObject1).next();
        localObject3 = new GroupDataHolder();
        ((GroupDataHolder)localObject3).id = ((DistrictInfo)localObject2).mId;
        ((GroupDataHolder)localObject3).name = ((DistrictInfo)localObject2).mName;
        this.groupDataList.add(localObject3);
        this.positionIdRelation.add(Integer.valueOf(((DistrictInfo)localObject2).mId));
      }
    }
  }
  
  public class ChildDataHolder
  {
    public String abbreviation;
    public int childPosition;
    public int groupPosition;
    public int id;
    public String name;
    public String pinyin;
    
    public ChildDataHolder() {}
  }
  
  public class DistrictComparator
    implements Comparator<DistrictInfo>
  {
    RuleBasedCollator chinese_cmp = (RuleBasedCollator)Collator.getInstance(Locale.CHINA);
    
    public DistrictComparator() {}
    
    public int compare(DistrictInfo paramDistrictInfo1, DistrictInfo paramDistrictInfo2)
    {
      String str = paramDistrictInfo1.mName;
      Object localObject = paramDistrictInfo2.mName;
      paramDistrictInfo1 = str;
      if (str.equals("重庆市")) {
        paramDistrictInfo1 = "宠庆市";
      }
      paramDistrictInfo2 = (DistrictInfo)localObject;
      if (((String)localObject).equals("重庆市")) {
        paramDistrictInfo2 = "宠庆市";
      }
      localObject = paramDistrictInfo1;
      if (paramDistrictInfo1.equals("长春市")) {
        localObject = "常春市";
      }
      paramDistrictInfo1 = paramDistrictInfo2;
      if (paramDistrictInfo2.equals("长春市")) {
        paramDistrictInfo1 = "常春市";
      }
      paramDistrictInfo2 = (DistrictInfo)localObject;
      if (((String)localObject).equals("长治市")) {
        paramDistrictInfo2 = "常治市";
      }
      localObject = paramDistrictInfo1;
      if (paramDistrictInfo1.equals("长治市")) {
        localObject = "常治市";
      }
      return this.chinese_cmp.compare(paramDistrictInfo2, (String)localObject);
    }
  }
  
  public class GroupDataHolder
  {
    public boolean alreadyDownload = false;
    public ArrayList<DistrictAdapter.ChildDataHolder> childList;
    public int id = -1;
    public int listType = 0;
    public String name = "province";
    
    public GroupDataHolder() {}
  }
  
  private class InitWordBookTask
    extends AsyncTask<Integer, Integer, Integer>
  {
    private InitWordBookTask() {}
    
    protected Integer doInBackground(Integer... paramVarArgs)
    {
      if (DistrictAdapter.this.mWordBook == null)
      {
        LogUtil.e("DistrictAdapter", "mWordBook == null");
        DistrictAdapter.access$102(DistrictAdapter.this, DistrictAdapter.this.initWordBook());
      }
      return null;
    }
  }
  
  public class WordBook
  {
    public ArrayList<Integer> cachePosition;
    public int childPosition = 0;
    public int groupPosition = 0;
    public HashMap<String, WordBook> nextMap;
    
    public WordBook() {}
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/adapter/DistrictAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */