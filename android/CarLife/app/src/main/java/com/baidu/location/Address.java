package com.baidu.location;

public final class Address
{
  public final String address;
  public final String city;
  public final String cityCode;
  public final String country;
  public final String countryCode;
  public final String district;
  public final String province;
  public final String street;
  public final String streetNumber;
  
  private Address(Builder paramBuilder)
  {
    this.country = paramBuilder.mCountry;
    this.countryCode = paramBuilder.mCountryCode;
    this.province = paramBuilder.mProvince;
    this.city = paramBuilder.mCity;
    this.cityCode = paramBuilder.mCityCode;
    this.district = paramBuilder.mDistrict;
    this.street = paramBuilder.mStreet;
    this.streetNumber = paramBuilder.mStreetNumber;
    this.address = paramBuilder.mAddress;
  }
  
  public static class Builder
  {
    private static final String BEI_JING = "北京";
    private static final String CHONG_QIN = "重庆";
    private static final String SHANG_HAI = "上海";
    private static final String TIAN_JIN = "天津";
    private String mAddress = null;
    private String mCity = null;
    private String mCityCode = null;
    private String mCountry = null;
    private String mCountryCode = null;
    private String mDistrict = null;
    private String mProvince = null;
    private String mStreet = null;
    private String mStreetNumber = null;
    
    public Address build()
    {
      StringBuffer localStringBuffer = new StringBuffer();
      if (this.mCountry != null) {
        localStringBuffer.append(this.mCountry);
      }
      if (this.mProvince != null) {
        localStringBuffer.append(this.mProvince);
      }
      if ((this.mProvince != null) && (this.mCity != null) && ((!this.mProvince.contains("北京")) || (!this.mCity.contains("北京"))) && ((!this.mProvince.contains("上海")) || (!this.mCity.contains("上海"))) && ((!this.mProvince.contains("天津")) || (!this.mCity.contains("天津"))) && ((!this.mProvince.contains("重庆")) || (!this.mCity.contains("重庆")))) {
        localStringBuffer.append(this.mCity);
      }
      if (this.mDistrict != null) {
        localStringBuffer.append(this.mDistrict);
      }
      if (this.mStreet != null) {
        localStringBuffer.append(this.mStreet);
      }
      if (this.mStreetNumber != null) {
        localStringBuffer.append(this.mStreetNumber);
      }
      if (localStringBuffer.length() > 0) {
        this.mAddress = localStringBuffer.toString();
      }
      return new Address(this, null);
    }
    
    public Builder city(String paramString)
    {
      this.mCity = paramString;
      return this;
    }
    
    public Builder cityCode(String paramString)
    {
      this.mCityCode = paramString;
      return this;
    }
    
    public Builder country(String paramString)
    {
      this.mCountry = paramString;
      return this;
    }
    
    public Builder countryCode(String paramString)
    {
      this.mCountryCode = paramString;
      return this;
    }
    
    public Builder district(String paramString)
    {
      this.mDistrict = paramString;
      return this;
    }
    
    public Builder province(String paramString)
    {
      this.mProvince = paramString;
      return this;
    }
    
    public Builder street(String paramString)
    {
      this.mStreet = paramString;
      return this;
    }
    
    public Builder streetNumber(String paramString)
    {
      this.mStreetNumber = paramString;
      return this;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/location/Address.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */