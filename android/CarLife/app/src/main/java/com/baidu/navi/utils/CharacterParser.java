package com.baidu.navi.utils;

import java.io.PrintStream;

public class CharacterParser
{
  private static CharacterParser characterParser = new CharacterParser();
  public static String[] pystr;
  private static int[] pyvalue = { 45217, 45219, 45232, 45241, 45244, 45253, 45271, 45279, 45294, 45306, 45485, 45500, 45504, 45510, 45534, 45546, 45550, 45554, 45560, 45731, 45752, 45761, 45762, 45773, 45780, 45785, 45790, 45795, 45797, 45808, 45811, 45821, 45996, 46005, 46011, 46021, 46036, 46052, 46057, 46069, 46247, 46248, 46255, 46261, 46266, 46273, 46275, 46287, 46293, 46294, 46298, 46301, 46309, 46312, 46318, 46324, 46498, 46513, 46518, 46530, 46533, 46540, 46559, 46575, 46584, 46753, 46762, 46763, 46773, 46780, 46795, 46801, 46805, 46814, 46826, 46839, 46840, 47010, 47018, 47035, 47046, 47058, 47073, 47088, 47089, 47090, 47297, 47299, 47305, 47316, 47325, 47335, 47352, 47353, 47355, 47524, 47539, 47548, 47566, 47572, 47575, 47586, 47589, 47605, 47608, 47614, 47777, 47784, 47803, 47806, 47815, 47833, 47835, 47839, 47844, 47853, 47860, 48040, 48049, 48054, 48068, 48082, 48103, 48109, 48119, 48334, 48351, 48553, 48566, 48594, 48621, 48803, 48828, 48830, 48847, 48872, 48879, 48889, 49062, 49066, 49071, 49077, 49084, 49088, 49103, 49107, 49109, 49113, 49117, 49124, 49129, 49133, 49135, 49143, 49316, 49320, 49324, 49331, 49334, 49349, 49356, 49365, 49367, 49378, 49381, 49577, 49578, 49592, 49603, 49616, 49621, 49633, 49647, 49658, 49829, 49835, 49855, 49869, 49875, 49877, 49884, 49896, 49905, 49911, 50082, 50088, 50100, 50101, 50117, 50120, 50128, 50142, 50151, 50159, 50161, 50167, 50173, 50174, 50353, 50356, 50371, 50378, 50383, 50386, 50387, 50392, 50393, 50395, 50396, 50397, 50408, 50415, 50417, 50419, 50426, 50427, 50595, 50599, 50603, 50606, 50607, 50608, 50610, 50614, 50615, 50622, 50628, 50634, 50642, 50647, 50654, 50663, 50665, 50679, 50858, 50862, 50866, 50868, 50873, 50882, 50891, 50906, 50942, 51107, 51129, 51137, 51152, 51157, 51168, 51181, 51183, 51191, 51366, 51377, 51385, 51387, 51391, 51396, 51399, 51401, 51411, 51413, 51414, 51424, 51427, 51437, 51439, 51442, 51444, 51446, 51449, 51453, 51619, 51622, 51626, 51629, 51630, 51631, 51640, 51642, 51658, 51666, 51677, 51689, 51705, 51878, 51925, 51935, 52130, 52132, 52136, 52138, 52141, 52145, 52149, 52153, 52169, 52177, 52180, 52193, 52196, 52207, 52210, 52218, 52389, 52398, 52416, 52429, 52440, 52441, 52445, 52460, 52468, 52473, 52476, 52648, 52661, 52665, 52676, 52678, 52684, 52687, 52698, 52705, 52707, 52724, 52734, 52929, 52939, 52942, 52951, 52980, 53177, 53190, 53216, 53236, 53416, 53437, 53447, 53462, 53469, 53478, 53497, 53669, 53675, 53689, 53705, 53738, 53755, 53932, 53947, 54000, 54178, 54196, 54197, 54212, 54233, 54439, 54459, 54469, 54481, 54484, 54491, 54495, 54498, 54512, 54516, 54517, 54518, 54522, 54698, 54704, 54721, 54736, 54746, 54756, 54772, 54949, 54992, 55003, 55017, 55205, 55207, 55208, 55214, 55221, 55227, 55229, 55240, 55255, 55262, 55266, 55274, 55276, 55280, 55282 };
  private String resource;
  
  static
  {
    pystr = new String[] { "a", "ai", "an", "ang", "ao", "ba", "bai", "ban", "bang", "bao", "bei", "ben", "beng", "bi", "bian", "biao", "bie", "bin", "bing", "bo", "bu", "ca", "cai", "can", "cang", "cao", "ce", "ceng", "cha", "chai", "chan", "chang", "chao", "che", "chen", "cheng", "chi", "chong", "chou", "chu", "chuai", "chuan", "chuang", "chui", "chun", "chuo", "ci", "cong", "cou", "cu", "cuan", "cui", "cun", "cuo", "da", "dai", "dan", "dang", "dao", "de", "deng", "di", "dian", "diao", "die", "ding", "diu", "dong", "dou", "du", "duan", "dui", "dun", "duo", "e", "en", "er", "fa", "fan", "fang", "fei", "fen", "feng", "fo", "fou", "fu", "ga", "gai", "gan", "gang", "gao", "ge", "gei", "gen", "geng", "gong", "gou", "gu", "gua", "guai", "guan", "guang", "gui", "gun", "guo", "ha", "hai", "han", "hang", "hao", "he", "hei", "hen", "heng", "hong", "hou", "hu", "hua", "huai", "huan", "huang", "hui", "hun", "huo", "ji", "jia", "jian", "jiang", "jiao", "jie", "jin", "jing", "jiong", "jiu", "ju", "juan", "jue", "jun", "ka", "kai", "kan", "kang", "kao", "ke", "ken", "keng", "kong", "kou", "ku", "kua", "kuai", "kuan", "kuang", "kui", "kun", "kuo", "la", "lai", "lan", "lang", "lao", "le", "lei", "leng", "li", "lia", "lian", "liang", "liao", "lie", "lin", "ling", "liu", "long", "lou", "lu", "lv", "luan", "lue", "lun", "luo", "ma", "mai", "man", "mang", "mao", "me", "mei", "men", "meng", "mi", "mian", "miao", "mie", "min", "ming", "miu", "mo", "mou", "mu", "na", "nai", "nan", "nang", "nao", "ne", "nei", "nen", "neng", "ni", "nian", "niang", "niao", "nie", "nin", "ning", "niu", "nong", "nu", "nv", "nuan", "nue", "nuo", "o", "ou", "pa", "pai", "pan", "pang", "pao", "pei", "pen", "peng", "pi", "pian", "piao", "pie", "pin", "ping", "po", "pu", "qi", "qia", "qian", "qiang", "qiao", "qie", "qin", "qing", "qiong", "qiu", "qu", "quan", "que", "qun", "ran", "rang", "rao", "re", "ren", "reng", "ri", "rong", "rou", "ru", "ruan", "rui", "run", "ruo", "sa", "sai", "san", "sang", "sao", "se", "sen", "seng", "sha", "shai", "shan", "shang", "shao", "she", "shen", "sheng", "shi", "shou", "shu", "shua", "shuai", "shuan", "shuang", "shui", "shun", "shuo", "si", "song", "sou", "su", "suan", "sui", "sun", "suo", "ta", "tai", "tan", "tang", "tao", "te", "teng", "ti", "tian", "tiao", "tie", "ting", "tong", "tou", "tu", "tuan", "tui", "tun", "tuo", "wa", "wai", "wan", "wang", "wei", "wen", "weng", "wo", "wu", "xi", "xia", "xian", "xiang", "xiao", "xie", "xin", "xing", "xiong", "xiu", "xu", "xuan", "xue", "xun", "ya", "yan", "yang", "yao", "ye", "yi", "yin", "ying", "yo", "yong", "you", "yu", "yuan", "yue", "yun", "za", "zai", "zan", "zang", "zao", "ze", "zei", "zen", "zeng", "zha", "zhai", "zhan", "zhang", "zhao", "zhe", "zhen", "zheng", "zhi", "zhong", "zhou", "zhu", "zhua", "zhuai", "zhuan", "zhuang", "zhui", "zhun", "zhuo", "zi", "zong", "zou", "zu", "zuan", "zui", "zun", "zuo" };
  }
  
  public static String convert(String paramString)
  {
    Object localObject = null;
    int j = getChsAscii(paramString);
    if ((j > 0) && (j < 160))
    {
      paramString = String.valueOf((char)j);
      return paramString;
    }
    int i = pyvalue.length - 1;
    for (;;)
    {
      paramString = (String)localObject;
      if (i < 0) {
        break;
      }
      if (pyvalue[i] <= j) {
        return pystr[i];
      }
      i -= 1;
    }
  }
  
  public static String getAbbreviation(String paramString, StringBuilder paramStringBuilder)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    if (i < paramString.length())
    {
      Object localObject = paramString.substring(i, i + 1);
      if (((String)localObject).getBytes().length >= 2)
      {
        String str = convert((String)localObject);
        localObject = str;
        if (str == null) {
          localObject = "unknown";
        }
      }
      for (;;)
      {
        localStringBuilder.append((String)localObject);
        paramStringBuilder.append(((String)localObject).charAt(0));
        i += 1;
        break;
      }
    }
    return localStringBuilder.toString();
  }
  
  public static int getChsAscii(String paramString)
  {
    int k = 0;
    int i = 0;
    int j = i;
    label77:
    do
    {
      try
      {
        paramString = paramString.getBytes("gb2312");
        if (paramString != null)
        {
          j = i;
          if (paramString.length <= 2)
          {
            j = i;
            if (paramString.length > 0) {
              break label77;
            }
          }
        }
        j = i;
        throw new RuntimeException("illegal resource string");
      }
      catch (Exception paramString)
      {
        System.out.println("ERROR:ChineseSpelling.class-getChsAscii(String chs)" + paramString);
        i = j;
        return i;
      }
      j = i;
      i = k;
      if (paramString.length == 1) {
        i = paramString[0];
      }
      j = i;
    } while (paramString.length != 2);
    i = paramString[0];
    j = paramString[1];
    return (i + 256) * 256 + (j + 256) - 65536;
  }
  
  public static CharacterParser getInstance()
  {
    return characterParser;
  }
  
  public static String getSelling(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    if (i < paramString.length())
    {
      Object localObject = paramString.substring(i, i + 1);
      if (((String)localObject).getBytes().length >= 2)
      {
        String str = convert((String)localObject);
        localObject = str;
        if (str == null) {
          localObject = "unknown";
        }
      }
      for (;;)
      {
        localStringBuilder.append((String)localObject);
        i += 1;
        break;
      }
    }
    return localStringBuilder.toString();
  }
  
  public String getResource()
  {
    return this.resource;
  }
  
  public void setResource(String paramString)
  {
    this.resource = paramString;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/utils/CharacterParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */