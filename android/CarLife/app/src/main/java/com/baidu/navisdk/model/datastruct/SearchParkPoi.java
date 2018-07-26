package com.baidu.navisdk.model.datastruct;

import com.baidu.nplatform.comapi.basestruct.GeoPoint;

public class SearchParkPoi {
    public String mAddress;
    public double mDbPriceDay;
    public double mDbPriceNight;
    public int mDistance;
    public int mDistrictId;
    public GeoPoint mGuidePoint;
    public int mId;
    public int mLeftCnt;
    public String mName;
    public String mOpenTime;
    public SearchParkKindEnum mParkKind;
    public SearchParkTypeEnum mParkType;
    public String mPhone;
    public String mTollText;
    public int mTotalCnt;
    public GeoPoint mViewPoint;

    public enum SearchParkFreeTypeEnum {
        Search_Park_FreeType_Unknown(0),
        Search_Park_FreeType_Lodging(1),
        Search_Park_FreeType_Meal(2),
        Search_Park_FreeType_Shopping(3),
        Search_Park_FreeType_ConsumptionLimit(4),
        Search_Park_FreeType_Relation(5),
        Search_Park_FreeType_InGroup(6);
        
        private int value;

        private SearchParkFreeTypeEnum(int value) {
            this.value = value;
        }

        public int getIndex() {
            return this.value;
        }

        public static SearchParkFreeTypeEnum valueOf(int value) {
            switch (value) {
                case 1:
                    return Search_Park_FreeType_Lodging;
                case 2:
                    return Search_Park_FreeType_Meal;
                case 3:
                    return Search_Park_FreeType_Shopping;
                case 4:
                    return Search_Park_FreeType_ConsumptionLimit;
                case 5:
                    return Search_Park_FreeType_Relation;
                case 6:
                    return Search_Park_FreeType_InGroup;
                default:
                    return Search_Park_FreeType_Unknown;
            }
        }
    }

    public enum SearchParkKindEnum {
        Search_ParkKind_Unknown(0),
        Search_ParkKind_Indoor(1),
        Search_ParkKind_Outdoor(2),
        Search_ParkKind_OnRoad(4),
        Search_ParkKind_OffRoad(8),
        Search_ParkKind_Overground(16),
        Search_ParkKind_Underground(32);
        
        private int value;

        private SearchParkKindEnum(int value) {
            this.value = value;
        }

        public int getIndex() {
            return this.value;
        }

        public static SearchParkKindEnum valueOf(int value) {
            switch (value) {
                case 1:
                    return Search_ParkKind_Indoor;
                case 2:
                    return Search_ParkKind_Outdoor;
                case 4:
                    return Search_ParkKind_OnRoad;
                case 8:
                    return Search_ParkKind_OffRoad;
                case 16:
                    return Search_ParkKind_Overground;
                case 32:
                    return Search_ParkKind_Underground;
                default:
                    return Search_ParkKind_Unknown;
            }
        }
    }

    public enum SearchParkTollTypeEnum {
        Search_Park_TollType_Unknown(0),
        Search_Park_TollType_WholeYear(1),
        Search_Park_TollType_WholeMonth(2),
        Search_Park_TollType_OneTime(3),
        Search_Park_TollType_ByTime(4),
        Search_Park_TollType_DiffTime(5),
        Search_Park_TollType_Free(6);
        
        private int value;

        private SearchParkTollTypeEnum(int value) {
            this.value = value;
        }

        public int getIndex() {
            return this.value;
        }

        public static SearchParkTollTypeEnum valueOf(int value) {
            switch (value) {
                case 1:
                    return Search_Park_TollType_WholeYear;
                case 2:
                    return Search_Park_TollType_WholeMonth;
                case 3:
                    return Search_Park_TollType_OneTime;
                case 4:
                    return Search_Park_TollType_ByTime;
                case 5:
                    return Search_Park_TollType_DiffTime;
                case 6:
                    return Search_Park_TollType_Free;
                default:
                    return Search_Park_TollType_Unknown;
            }
        }
    }

    public enum SearchParkTypeEnum {
        Search_Park_Type_Unknown(0),
        Search_Park_Type_SelfRun(1),
        Search_Park_Type_MechanicalRun(2),
        Search_Park_Type_3DMechanicalRun(3);
        
        private int value;

        private SearchParkTypeEnum(int value) {
            this.value = value;
        }

        public int getIndex() {
            return this.value;
        }

        public static SearchParkTypeEnum valueOf(int value) {
            switch (value) {
                case 1:
                    return Search_Park_Type_SelfRun;
                case 2:
                    return Search_Park_Type_MechanicalRun;
                case 3:
                    return Search_Park_Type_3DMechanicalRun;
                default:
                    return Search_Park_Type_Unknown;
            }
        }
    }
}
