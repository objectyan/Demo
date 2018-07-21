package com.baidu.che.codriver.util;

import android.text.TextUtils;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Locale;

public class g
{
  public static final char[] a = { -27073, 21710, 23433, -32594, 20985, 20843, 25344, 25203, -28506, 21241, -27070, 22868, 20283, 23620, -28743, 28780, 24971, 27715, 20907, 30326, 23788, 22163, 20594, 21442, 20179, 25761, 20874, 23934, 26365, 26366, 23652, 21449, -32122, -28737, 20261, 25220, -28826, 25275, 27784, 27785, -27081, 21507, 20805, 25277, 20986, 27451, 25571, 24027, 20997, 21561, 26110, -28620, 21618, 21254, 20945, 31895, 27718, 23828, -28504, 25619, 21649, 21574, 20025, 24403, 20992, 22042, 25189, 28783, 27664, 22002, 30008, 20993, 29241, 19969, 19999, 19996, 21562, 21438, -32751, -30360, 21544, 22810, 22968, -29706, 22848, -26715, 20799, 21457, 24070, 21274, -26402, 20998, 20016, -30331, 20175, 32017, 20245, 26094, 20357, 29976, 20872, 30347, 25096, 32473, 26681, 21039, 24037, 21246, 20272, 29916, 20054, 20851, 20809, 24402, 20008, 21593, 21704, 21645, 20292, 22831, -31968, -29757, -24878, 25323, 20136, 22135, 21503, -24767, 20079, -32079, 24576, 29375, 24031, 28784, 26127, 21529, 19980, 21152, 25099, 27743, -32131, -27082, 24062, 22357, 20866, 20009, 20965, 23010, 22104, 20891, 21652, 24320, 21002, 24572, 23611, 21308, -32626, 21157, 31354, 25248, 25181, 22840, -31569, 23485, 21281, 20111, 22372, 25193, 22403, 26469, 20848, 21879, 25438, -32629, 21202, 23834, 21013, 20457, 22849, -32145, 25769, 21015, 25294, 21026, 28316, 22230, -24679, 30620, 22108, 23048, 30055, 25249, 32599, 21603, 22920, 22475, 23258, 29284, 29483, 20040, 21573, -27160, 30015, 21674, 23424, 21941, 20060, 27665, 21517, -29652, 25720, 21726, 27626, 21999, 25295, -32439, 22241, 22228, 23404, 30098, 23070, 24641, -32515, 22958, 25288, 23330, -25057, 25423, 22236, 23425, 22942, 20892, 32698, 22900, 22907, 30111, -24895, -28467, 21908, -29772, 22929, 25293, 30469, 20051, 25243, 21624, 21943, 21257, 19989, 22248, 21117, 27669, 23000, 20050, -27509, 21078, 20166, 19971, 25488, 21315, 21595, 24708, 30335, 20146, 29381, -32114, 19992, 21306, 23761, 32570, 22795, 21605, 31331, 23046, 24825, 20154, 25172, 26085, -31944, 21433, -28518, 25404, 22567, 23121, 30628, 25468, 20200, 27618, 19977, 26706, 25531, -27222, 26862, 20711, 26432, 31579, 23665, 20260, 24368, 22882, 30003, -31848, 25938, 21319, 23608, 21454, 20070, 21047, -30608, -27159, 21452, -29695, 21550, -29708, 21430, 24554, 25436, -32049, 29435, 22794, 23385, 21766, 20182, 22268, 22349, 27748, 22834, 24529, 29093, 21076, 22825, 26091, 24086, 21381, 22258, 20599, 20984, 28237, 25512, 21534, 20039, 31349, 27498, 24367, 23587, 21361, 26167, 32705, 25373, 20044, 22805, -31118, 20186, 20065, 28785, 20123, 24515, 26143, 20982, 20241, 21505, 21509, 21066, 22339, 20011, 24697, 22830, 24186, 20539, 19968, 22233, 24212, 21727, 20323, 20248, 25180, 22246, 26352, 26197, 31584, 31612, 24064, 28797, 20802, 21288, 20654, 21017, -29380, 24590, 22679, 25166, 25434, 27838, 24352, -27265, -27273, 20299, -30969, -29410, 20105, 20043, 23769, 24226, 20013, 24030, 26417, 25235, 25341, 19987, 22918, -26951, 23442, 21331, 20082, 23447, -28487, 31199, -27461, 21404, 23562, 26152, 20825, -24637, -24636 };
  public static final byte[][] b;
  private static final String c = "HanziToPinyin";
  private static final boolean d = false;
  private static final String e = "阿";
  private static final String f = "鿿";
  private static final Collator g = Collator.getInstance(Locale.CHINA);
  private static g h;
  private final boolean i;
  
  static
  {
    byte[] arrayOfByte1 = { 65, 0, 0, 0, 0, 0 };
    byte[] arrayOfByte2 = { 65, 78, 71, 0, 0, 0 };
    byte[] arrayOfByte3 = { 66, 65, 73, 0, 0, 0 };
    byte[] arrayOfByte4 = { 66, 65, 78, 0, 0, 0 };
    byte[] arrayOfByte5 = { 66, 65, 78, 71, 0, 0 };
    byte[] arrayOfByte6 = { 66, 69, 78, 0, 0, 0 };
    byte[] arrayOfByte7 = { 66, 69, 78, 71, 0, 0 };
    byte[] arrayOfByte8 = { 66, 73, 0, 0, 0, 0 };
    byte[] arrayOfByte9 = { 66, 73, 69, 0, 0, 0 };
    byte[] arrayOfByte10 = { 66, 85, 0, 0, 0, 0 };
    byte[] arrayOfByte11 = { 67, 65, 73, 0, 0, 0 };
    byte[] arrayOfByte12 = { 67, 65, 78, 0, 0, 0 };
    byte[] arrayOfByte13 = { 67, 65, 78, 71, 0, 0 };
    byte[] arrayOfByte14 = { 67, 65, 79, 0, 0, 0 };
    byte[] arrayOfByte15 = { 67, 69, 78, 0, 0, 0 };
    byte[] arrayOfByte16 = { 67, 69, 78, 71, 0, 0 };
    byte[] arrayOfByte17 = { 90, 69, 78, 71, 0, 0 };
    byte[] arrayOfByte18 = { 67, 72, 65, 0, 0, 0 };
    byte[] arrayOfByte19 = { 67, 72, 65, 78, 71, 0 };
    byte[] arrayOfByte20 = { 83, 72, 69, 78, 0, 0 };
    byte[] arrayOfByte21 = { 67, 72, 73, 0, 0, 0 };
    byte[] arrayOfByte22 = { 67, 72, 85, 65, 0, 0 };
    byte[] arrayOfByte23 = { 67, 72, 85, 65, 73, 0 };
    byte[] arrayOfByte24 = { 67, 72, 85, 79, 0, 0 };
    byte[] arrayOfByte25 = { 67, 85, 65, 78, 0, 0 };
    byte[] arrayOfByte26 = { 67, 85, 78, 0, 0, 0 };
    byte[] arrayOfByte27 = { 67, 85, 79, 0, 0, 0 };
    byte[] arrayOfByte28 = { 68, 65, 73, 0, 0, 0 };
    byte[] arrayOfByte29 = { 68, 65, 78, 71, 0, 0 };
    byte[] arrayOfByte30 = { 68, 65, 79, 0, 0, 0 };
    byte[] arrayOfByte31 = { 68, 69, 0, 0, 0, 0 };
    byte[] arrayOfByte32 = { 68, 69, 78, 0, 0, 0 };
    byte[] arrayOfByte33 = { 68, 73, 0, 0, 0, 0 };
    byte[] arrayOfByte34 = { 68, 73, 78, 71, 0, 0 };
    byte[] arrayOfByte35 = { 68, 85, 0, 0, 0, 0 };
    byte[] arrayOfByte36 = { 68, 85, 65, 78, 0, 0 };
    byte[] arrayOfByte37 = { 68, 85, 78, 0, 0, 0 };
    byte[] arrayOfByte38 = { 69, 0, 0, 0, 0, 0 };
    byte[] arrayOfByte39 = { 69, 78, 0, 0, 0, 0 };
    byte[] arrayOfByte40 = { 70, 65, 0, 0, 0, 0 };
    byte[] arrayOfByte41 = { 70, 65, 78, 0, 0, 0 };
    byte[] arrayOfByte42 = { 70, 69, 73, 0, 0, 0 };
    byte[] arrayOfByte43 = { 70, 73, 65, 79, 0, 0 };
    byte[] arrayOfByte44 = { 71, 65, 73, 0, 0, 0 };
    byte[] arrayOfByte45 = { 71, 65, 79, 0, 0, 0 };
    byte[] arrayOfByte46 = { 71, 69, 0, 0, 0, 0 };
    byte[] arrayOfByte47 = { 71, 69, 78, 71, 0, 0 };
    byte[] arrayOfByte48 = { 71, 79, 78, 71, 0, 0 };
    byte[] arrayOfByte49 = { 71, 85, 65, 73, 0, 0 };
    byte[] arrayOfByte50 = { 71, 85, 65, 78, 0, 0 };
    byte[] arrayOfByte51 = { 71, 85, 78, 0, 0, 0 };
    byte[] arrayOfByte52 = { 71, 85, 79, 0, 0, 0 };
    byte[] arrayOfByte53 = { 72, 65, 0, 0, 0, 0 };
    byte[] arrayOfByte54 = { 72, 65, 78, 0, 0, 0 };
    byte[] arrayOfByte55 = { 72, 65, 79, 0, 0, 0 };
    byte[] arrayOfByte56 = { 72, 69, 73, 0, 0, 0 };
    byte[] arrayOfByte57 = { 72, 69, 78, 71, 0, 0 };
    byte[] arrayOfByte58 = { 72, 77, 0, 0, 0, 0 };
    byte[] arrayOfByte59 = { 72, 85, 65, 78, 71, 0 };
    byte[] arrayOfByte60 = { 72, 85, 78, 0, 0, 0 };
    byte[] arrayOfByte61 = { 72, 85, 79, 0, 0, 0 };
    byte[] arrayOfByte62 = { 74, 73, 0, 0, 0, 0 };
    byte[] arrayOfByte63 = { 74, 73, 69, 0, 0, 0 };
    byte[] arrayOfByte64 = { 74, 73, 78, 0, 0, 0 };
    byte[] arrayOfByte65 = { 74, 73, 78, 71, 0, 0 };
    byte[] arrayOfByte66 = { 74, 73, 79, 78, 71, 0 };
    byte[] arrayOfByte67 = { 74, 73, 85, 0, 0, 0 };
    byte[] arrayOfByte68 = { 74, 85, 0, 0, 0, 0 };
    byte[] arrayOfByte69 = { 74, 85, 78, 0, 0, 0 };
    byte[] arrayOfByte70 = { 75, 65, 78, 0, 0, 0 };
    byte[] arrayOfByte71 = { 75, 65, 79, 0, 0, 0 };
    byte[] arrayOfByte72 = { 75, 69, 0, 0, 0, 0 };
    byte[] arrayOfByte73 = { 75, 69, 78, 0, 0, 0 };
    byte[] arrayOfByte74 = { 75, 69, 78, 71, 0, 0 };
    byte[] arrayOfByte75 = { 75, 79, 78, 71, 0, 0 };
    byte[] arrayOfByte76 = { 75, 85, 0, 0, 0, 0 };
    byte[] arrayOfByte77 = { 75, 85, 65, 0, 0, 0 };
    byte[] arrayOfByte78 = { 75, 85, 65, 73, 0, 0 };
    byte[] arrayOfByte79 = { 75, 85, 65, 78, 0, 0 };
    byte[] arrayOfByte80 = { 75, 85, 65, 78, 71, 0 };
    byte[] arrayOfByte81 = { 75, 85, 73, 0, 0, 0 };
    byte[] arrayOfByte82 = { 75, 85, 79, 0, 0, 0 };
    byte[] arrayOfByte83 = { 76, 65, 0, 0, 0, 0 };
    byte[] arrayOfByte84 = { 76, 65, 73, 0, 0, 0 };
    byte[] arrayOfByte85 = { 76, 65, 79, 0, 0, 0 };
    byte[] arrayOfByte86 = { 76, 69, 0, 0, 0, 0 };
    byte[] arrayOfByte87 = { 76, 69, 78, 71, 0, 0 };
    byte[] arrayOfByte88 = { 76, 73, 0, 0, 0, 0 };
    byte[] arrayOfByte89 = { 76, 73, 69, 0, 0, 0 };
    byte[] arrayOfByte90 = { 76, 73, 78, 0, 0, 0 };
    byte[] arrayOfByte91 = { 76, 73, 78, 71, 0, 0 };
    byte[] arrayOfByte92 = { 76, 73, 85, 0, 0, 0 };
    byte[] arrayOfByte93 = { 76, 79, 0, 0, 0, 0 };
    byte[] arrayOfByte94 = { 76, 79, 78, 71, 0, 0 };
    byte[] arrayOfByte95 = { 76, 79, 85, 0, 0, 0 };
    byte[] arrayOfByte96 = { 76, 85, 65, 78, 0, 0 };
    byte[] arrayOfByte97 = { 76, 85, 69, 0, 0, 0 };
    byte[] arrayOfByte98 = { 76, 85, 78, 0, 0, 0 };
    byte[] arrayOfByte99 = { 77, 0, 0, 0, 0, 0 };
    byte[] arrayOfByte100 = { 77, 65, 79, 0, 0, 0 };
    byte[] arrayOfByte101 = { 77, 69, 78, 0, 0, 0 };
    byte[] arrayOfByte102 = { 77, 73, 0, 0, 0, 0 };
    byte[] arrayOfByte103 = { 77, 73, 65, 78, 0, 0 };
    byte[] arrayOfByte104 = { 77, 73, 65, 79, 0, 0 };
    byte[] arrayOfByte105 = { 77, 73, 78, 0, 0, 0 };
    byte[] arrayOfByte106 = { 77, 73, 85, 0, 0, 0 };
    byte[] arrayOfByte107 = { 77, 79, 0, 0, 0, 0 };
    byte[] arrayOfByte108 = { 77, 79, 85, 0, 0, 0 };
    byte[] arrayOfByte109 = { 78, 65, 0, 0, 0, 0 };
    byte[] arrayOfByte110 = { 78, 65, 73, 0, 0, 0 };
    byte[] arrayOfByte111 = { 78, 65, 79, 0, 0, 0 };
    byte[] arrayOfByte112 = { 78, 69, 0, 0, 0, 0 };
    byte[] arrayOfByte113 = { 78, 69, 73, 0, 0, 0 };
    byte[] arrayOfByte114 = { 78, 69, 78, 0, 0, 0 };
    byte[] arrayOfByte115 = { 78, 69, 78, 71, 0, 0 };
    byte[] arrayOfByte116 = { 78, 73, 65, 78, 0, 0 };
    byte[] arrayOfByte117 = { 78, 73, 65, 78, 71, 0 };
    byte[] arrayOfByte118 = { 78, 73, 65, 79, 0, 0 };
    byte[] arrayOfByte119 = { 78, 73, 69, 0, 0, 0 };
    byte[] arrayOfByte120 = { 78, 73, 78, 0, 0, 0 };
    byte[] arrayOfByte121 = { 78, 73, 78, 71, 0, 0 };
    byte[] arrayOfByte122 = { 78, 73, 85, 0, 0, 0 };
    byte[] arrayOfByte123 = { 78, 79, 78, 71, 0, 0 };
    byte[] arrayOfByte124 = { 78, 79, 85, 0, 0, 0 };
    byte[] arrayOfByte125 = { 78, 85, 65, 78, 0, 0 };
    byte[] arrayOfByte126 = { 78, 85, 78, 0, 0, 0 };
    byte[] arrayOfByte127 = { 79, 0, 0, 0, 0, 0 };
    byte[] arrayOfByte128 = { 79, 85, 0, 0, 0, 0 };
    byte[] arrayOfByte129 = { 80, 65, 78, 71, 0, 0 };
    byte[] arrayOfByte130 = { 80, 65, 79, 0, 0, 0 };
    byte[] arrayOfByte131 = { 80, 69, 73, 0, 0, 0 };
    byte[] arrayOfByte132 = { 80, 69, 78, 71, 0, 0 };
    byte[] arrayOfByte133 = { 80, 73, 0, 0, 0, 0 };
    byte[] arrayOfByte134 = { 80, 73, 78, 0, 0, 0 };
    byte[] arrayOfByte135 = { 80, 73, 78, 71, 0, 0 };
    byte[] arrayOfByte136 = { 80, 79, 0, 0, 0, 0 };
    byte[] arrayOfByte137 = { 80, 79, 85, 0, 0, 0 };
    byte[] arrayOfByte138 = { 81, 73, 65, 78, 71, 0 };
    byte[] arrayOfByte139 = { 81, 73, 69, 0, 0, 0 };
    byte[] arrayOfByte140 = { 81, 73, 79, 78, 71, 0 };
    byte[] arrayOfByte141 = { 81, 73, 85, 0, 0, 0 };
    byte[] arrayOfByte142 = { 81, 85, 65, 78, 0, 0 };
    byte[] arrayOfByte143 = { 81, 85, 78, 0, 0, 0 };
    byte[] arrayOfByte144 = { 82, 65, 78, 0, 0, 0 };
    byte[] arrayOfByte145 = { 82, 65, 78, 71, 0, 0 };
    byte[] arrayOfByte146 = { 82, 85, 79, 0, 0, 0 };
    byte[] arrayOfByte147 = { 83, 65, 0, 0, 0, 0 };
    byte[] arrayOfByte148 = { 83, 65, 73, 0, 0, 0 };
    byte[] arrayOfByte149 = { 83, 65, 78, 0, 0, 0 };
    byte[] arrayOfByte150 = { 83, 65, 78, 71, 0, 0 };
    byte[] arrayOfByte151 = { 83, 69, 0, 0, 0, 0 };
    byte[] arrayOfByte152 = { 83, 69, 78, 71, 0, 0 };
    byte[] arrayOfByte153 = { 83, 72, 65, 0, 0, 0 };
    byte[] arrayOfByte154 = { 83, 72, 65, 79, 0, 0 };
    byte[] arrayOfByte155 = { 83, 72, 69, 0, 0, 0 };
    byte[] arrayOfByte156 = { 83, 72, 69, 78, 0, 0 };
    byte[] arrayOfByte157 = { 88, 73, 78, 0, 0, 0 };
    byte[] arrayOfByte158 = { 83, 72, 69, 78, 0, 0 };
    byte[] arrayOfByte159 = { 83, 72, 73, 0, 0, 0 };
    byte[] arrayOfByte160 = { 83, 72, 85, 0, 0, 0 };
    byte[] arrayOfByte161 = { 83, 72, 85, 65, 0, 0 };
    byte[] arrayOfByte162 = { 83, 72, 85, 65, 73, 0 };
    byte[] arrayOfByte163 = { 83, 72, 85, 65, 78, 0 };
    byte[] arrayOfByte164 = { 83, 72, 85, 65, 78, 71 };
    byte[] arrayOfByte165 = { 83, 72, 85, 73, 0, 0 };
    byte[] arrayOfByte166 = { 83, 73, 0, 0, 0, 0 };
    byte[] arrayOfByte167 = { 83, 79, 78, 71, 0, 0 };
    byte[] arrayOfByte168 = { 83, 79, 85, 0, 0, 0 };
    byte[] arrayOfByte169 = { 83, 85, 0, 0, 0, 0 };
    byte[] arrayOfByte170 = { 83, 85, 73, 0, 0, 0 };
    byte[] arrayOfByte171 = { 83, 85, 78, 0, 0, 0 };
    byte[] arrayOfByte172 = { 84, 65, 0, 0, 0, 0 };
    byte[] arrayOfByte173 = { 84, 65, 79, 0, 0, 0 };
    byte[] arrayOfByte174 = { 84, 69, 0, 0, 0, 0 };
    byte[] arrayOfByte175 = { 84, 69, 78, 71, 0, 0 };
    byte[] arrayOfByte176 = { 84, 73, 0, 0, 0, 0 };
    byte[] arrayOfByte177 = { 84, 73, 69, 0, 0, 0 };
    byte[] arrayOfByte178 = { 84, 79, 78, 71, 0, 0 };
    byte[] arrayOfByte179 = { 84, 85, 0, 0, 0, 0 };
    byte[] arrayOfByte180 = { 87, 65, 73, 0, 0, 0 };
    byte[] arrayOfByte181 = { 87, 65, 78, 0, 0, 0 };
    byte[] arrayOfByte182 = { 87, 65, 78, 71, 0, 0 };
    byte[] arrayOfByte183 = { 87, 69, 78, 0, 0, 0 };
    byte[] arrayOfByte184 = { 87, 69, 78, 71, 0, 0 };
    byte[] arrayOfByte185 = { 87, 79, 0, 0, 0, 0 };
    byte[] arrayOfByte186 = { 88, 73, 65, 78, 0, 0 };
    byte[] arrayOfByte187 = { 88, 73, 65, 79, 0, 0 };
    byte[] arrayOfByte188 = { 88, 73, 78, 0, 0, 0 };
    byte[] arrayOfByte189 = { 88, 73, 79, 78, 71, 0 };
    byte[] arrayOfByte190 = { 88, 73, 85, 0, 0, 0 };
    byte[] arrayOfByte191 = { 88, 85, 65, 78, 0, 0 };
    byte[] arrayOfByte192 = { 88, 85, 78, 0, 0, 0 };
    byte[] arrayOfByte193 = { 89, 65, 0, 0, 0, 0 };
    byte[] arrayOfByte194 = { 89, 65, 78, 0, 0, 0 };
    byte[] arrayOfByte195 = { 89, 65, 79, 0, 0, 0 };
    byte[] arrayOfByte196 = { 89, 73, 78, 0, 0, 0 };
    byte[] arrayOfByte197 = { 89, 79, 85, 0, 0, 0 };
    byte[] arrayOfByte198 = { 89, 85, 65, 78, 0, 0 };
    byte[] arrayOfByte199 = { 89, 85, 78, 0, 0, 0 };
    byte[] arrayOfByte200 = { 90, 65, 79, 0, 0, 0 };
    byte[] arrayOfByte201 = { 90, 69, 73, 0, 0, 0 };
    byte[] arrayOfByte202 = { 90, 69, 78, 71, 0, 0 };
    byte[] arrayOfByte203 = { 90, 72, 65, 73, 0, 0 };
    byte[] arrayOfByte204 = { 67, 72, 65, 78, 71, 0 };
    byte[] arrayOfByte205 = { 90, 72, 65, 79, 0, 0 };
    byte[] arrayOfByte206 = { 90, 72, 69, 0, 0, 0 };
    byte[] arrayOfByte207 = { 90, 72, 69, 78, 0, 0 };
    byte[] arrayOfByte208 = { 83, 72, 73, 0, 0, 0 };
    byte[] arrayOfByte209 = { 90, 72, 79, 78, 71, 0 };
    byte[] arrayOfByte210 = { 90, 72, 79, 85, 0, 0 };
    byte[] arrayOfByte211 = { 90, 72, 85, 65, 73, 0 };
    byte[] arrayOfByte212 = { 90, 72, 85, 65, 78, 0 };
    byte[] arrayOfByte213 = { 90, 72, 85, 65, 78, 71 };
    byte[] arrayOfByte214 = { 90, 72, 85, 79, 0, 0 };
    byte[] arrayOfByte215 = { 90, 79, 85, 0, 0, 0 };
    byte[] arrayOfByte216 = { 90, 85, 0, 0, 0, 0 };
    byte[] arrayOfByte217 = { 90, 85, 73, 0, 0, 0 };
    byte[] arrayOfByte218 = { 90, 85, 79, 0, 0, 0 };
    b = new byte[][] { arrayOfByte1, { 65, 73, 0, 0, 0, 0 }, { 65, 78, 0, 0, 0, 0 }, arrayOfByte2, { 65, 79, 0, 0, 0, 0 }, { 66, 65, 0, 0, 0, 0 }, arrayOfByte3, arrayOfByte4, arrayOfByte5, { 66, 65, 79, 0, 0, 0 }, { 66, 69, 73, 0, 0, 0 }, arrayOfByte6, arrayOfByte7, arrayOfByte8, { 66, 73, 65, 78, 0, 0 }, { 66, 73, 65, 79, 0, 0 }, arrayOfByte9, { 66, 73, 78, 0, 0, 0 }, { 66, 73, 78, 71, 0, 0 }, { 66, 79, 0, 0, 0, 0 }, arrayOfByte10, { 67, 65, 0, 0, 0, 0 }, arrayOfByte11, arrayOfByte12, arrayOfByte13, arrayOfByte14, { 67, 69, 0, 0, 0, 0 }, arrayOfByte15, arrayOfByte16, arrayOfByte17, { 67, 69, 78, 71, 0, 0 }, arrayOfByte18, { 67, 72, 65, 73, 0, 0 }, { 67, 72, 65, 78, 0, 0 }, arrayOfByte19, { 67, 72, 65, 79, 0, 0 }, { 67, 72, 69, 0, 0, 0 }, { 67, 72, 69, 78, 0, 0 }, arrayOfByte20, { 67, 72, 69, 78, 0, 0 }, { 67, 72, 69, 78, 71, 0 }, arrayOfByte21, { 67, 72, 79, 78, 71, 0 }, { 67, 72, 79, 85, 0, 0 }, { 67, 72, 85, 0, 0, 0 }, arrayOfByte22, arrayOfByte23, { 67, 72, 85, 65, 78, 0 }, { 67, 72, 85, 65, 78, 71 }, { 67, 72, 85, 73, 0, 0 }, { 67, 72, 85, 78, 0, 0 }, arrayOfByte24, { 67, 73, 0, 0, 0, 0 }, { 67, 79, 78, 71, 0, 0 }, { 67, 79, 85, 0, 0, 0 }, { 67, 85, 0, 0, 0, 0 }, arrayOfByte25, { 67, 85, 73, 0, 0, 0 }, arrayOfByte26, arrayOfByte27, { 68, 65, 0, 0, 0, 0 }, arrayOfByte28, { 68, 65, 78, 0, 0, 0 }, arrayOfByte29, arrayOfByte30, arrayOfByte31, arrayOfByte32, { 68, 69, 78, 71, 0, 0 }, arrayOfByte33, { 68, 73, 65, 0, 0, 0 }, { 68, 73, 65, 78, 0, 0 }, { 68, 73, 65, 79, 0, 0 }, { 68, 73, 69, 0, 0, 0 }, arrayOfByte34, { 68, 73, 85, 0, 0, 0 }, { 68, 79, 78, 71, 0, 0 }, { 68, 79, 85, 0, 0, 0 }, arrayOfByte35, arrayOfByte36, { 68, 85, 73, 0, 0, 0 }, arrayOfByte37, { 68, 85, 79, 0, 0, 0 }, arrayOfByte38, { 69, 73, 0, 0, 0, 0 }, arrayOfByte39, { 69, 78, 71, 0, 0, 0 }, { 69, 82, 0, 0, 0, 0 }, arrayOfByte40, arrayOfByte41, { 70, 65, 78, 71, 0, 0 }, arrayOfByte42, { 70, 69, 78, 0, 0, 0 }, { 70, 69, 78, 71, 0, 0 }, arrayOfByte43, { 70, 79, 0, 0, 0, 0 }, { 70, 79, 85, 0, 0, 0 }, { 70, 85, 0, 0, 0, 0 }, { 71, 65, 0, 0, 0, 0 }, arrayOfByte44, { 71, 65, 78, 0, 0, 0 }, { 71, 65, 78, 71, 0, 0 }, arrayOfByte45, arrayOfByte46, { 71, 69, 73, 0, 0, 0 }, { 71, 69, 78, 0, 0, 0 }, arrayOfByte47, arrayOfByte48, { 71, 79, 85, 0, 0, 0 }, { 71, 85, 0, 0, 0, 0 }, { 71, 85, 65, 0, 0, 0 }, arrayOfByte49, arrayOfByte50, { 71, 85, 65, 78, 71, 0 }, { 71, 85, 73, 0, 0, 0 }, arrayOfByte51, arrayOfByte52, arrayOfByte53, { 72, 65, 73, 0, 0, 0 }, arrayOfByte54, { 72, 65, 78, 71, 0, 0 }, arrayOfByte55, { 72, 69, 0, 0, 0, 0 }, arrayOfByte56, { 72, 69, 78, 0, 0, 0 }, arrayOfByte57, arrayOfByte58, { 72, 79, 78, 71, 0, 0 }, { 72, 79, 85, 0, 0, 0 }, { 72, 85, 0, 0, 0, 0 }, { 72, 85, 65, 0, 0, 0 }, { 72, 85, 65, 73, 0, 0 }, { 72, 85, 65, 78, 0, 0 }, arrayOfByte59, { 72, 85, 73, 0, 0, 0 }, arrayOfByte60, arrayOfByte61, arrayOfByte62, { 74, 73, 65, 0, 0, 0 }, { 74, 73, 65, 78, 0, 0 }, { 74, 73, 65, 78, 71, 0 }, { 74, 73, 65, 79, 0, 0 }, arrayOfByte63, arrayOfByte64, arrayOfByte65, arrayOfByte66, arrayOfByte67, arrayOfByte68, { 74, 85, 65, 78, 0, 0 }, { 74, 85, 69, 0, 0, 0 }, arrayOfByte69, { 75, 65, 0, 0, 0, 0 }, { 75, 65, 73, 0, 0, 0 }, arrayOfByte70, { 75, 65, 78, 71, 0, 0 }, arrayOfByte71, arrayOfByte72, arrayOfByte73, arrayOfByte74, arrayOfByte75, { 75, 79, 85, 0, 0, 0 }, arrayOfByte76, arrayOfByte77, arrayOfByte78, arrayOfByte79, arrayOfByte80, arrayOfByte81, { 75, 85, 78, 0, 0, 0 }, arrayOfByte82, arrayOfByte83, arrayOfByte84, { 76, 65, 78, 0, 0, 0 }, { 76, 65, 78, 71, 0, 0 }, arrayOfByte85, arrayOfByte86, { 76, 69, 73, 0, 0, 0 }, arrayOfByte87, arrayOfByte88, { 76, 73, 65, 0, 0, 0 }, { 76, 73, 65, 78, 0, 0 }, { 76, 73, 65, 78, 71, 0 }, { 76, 73, 65, 79, 0, 0 }, arrayOfByte89, arrayOfByte90, arrayOfByte91, arrayOfByte92, arrayOfByte93, arrayOfByte94, arrayOfByte95, { 76, 85, 0, 0, 0, 0 }, arrayOfByte96, arrayOfByte97, arrayOfByte98, { 76, 85, 79, 0, 0, 0 }, arrayOfByte99, { 77, 65, 0, 0, 0, 0 }, { 77, 65, 73, 0, 0, 0 }, { 77, 65, 78, 0, 0, 0 }, { 77, 65, 78, 71, 0, 0 }, arrayOfByte100, { 77, 69, 0, 0, 0, 0 }, { 77, 69, 73, 0, 0, 0 }, arrayOfByte101, { 77, 69, 78, 71, 0, 0 }, arrayOfByte102, arrayOfByte103, arrayOfByte104, { 77, 73, 69, 0, 0, 0 }, arrayOfByte105, { 77, 73, 78, 71, 0, 0 }, arrayOfByte106, arrayOfByte107, arrayOfByte108, { 77, 85, 0, 0, 0, 0 }, { 78, 0, 0, 0, 0, 0 }, arrayOfByte109, arrayOfByte110, { 78, 65, 78, 0, 0, 0 }, { 78, 65, 78, 71, 0, 0 }, arrayOfByte111, arrayOfByte112, arrayOfByte113, arrayOfByte114, arrayOfByte115, { 78, 73, 0, 0, 0, 0 }, arrayOfByte116, arrayOfByte117, arrayOfByte118, arrayOfByte119, arrayOfByte120, arrayOfByte121, arrayOfByte122, arrayOfByte123, arrayOfByte124, { 78, 85, 0, 0, 0, 0 }, arrayOfByte125, { 78, 85, 69, 0, 0, 0 }, arrayOfByte126, { 78, 85, 79, 0, 0, 0 }, arrayOfByte127, arrayOfByte128, { 80, 65, 0, 0, 0, 0 }, { 80, 65, 73, 0, 0, 0 }, { 80, 65, 78, 0, 0, 0 }, arrayOfByte129, arrayOfByte130, arrayOfByte131, { 80, 69, 78, 0, 0, 0 }, arrayOfByte132, arrayOfByte133, { 80, 73, 65, 78, 0, 0 }, { 80, 73, 65, 79, 0, 0 }, { 80, 73, 69, 0, 0, 0 }, arrayOfByte134, arrayOfByte135, arrayOfByte136, arrayOfByte137, { 80, 85, 0, 0, 0, 0 }, { 81, 73, 0, 0, 0, 0 }, { 81, 73, 65, 0, 0, 0 }, { 81, 73, 65, 78, 0, 0 }, arrayOfByte138, { 81, 73, 65, 79, 0, 0 }, arrayOfByte139, { 81, 73, 78, 0, 0, 0 }, { 81, 73, 78, 71, 0, 0 }, arrayOfByte140, arrayOfByte141, { 81, 85, 0, 0, 0, 0 }, arrayOfByte142, { 81, 85, 69, 0, 0, 0 }, arrayOfByte143, arrayOfByte144, arrayOfByte145, { 82, 65, 79, 0, 0, 0 }, { 82, 69, 0, 0, 0, 0 }, { 82, 69, 78, 0, 0, 0 }, { 82, 69, 78, 71, 0, 0 }, { 82, 73, 0, 0, 0, 0 }, { 82, 79, 78, 71, 0, 0 }, { 82, 79, 85, 0, 0, 0 }, { 82, 85, 0, 0, 0, 0 }, { 82, 85, 65, 0, 0, 0 }, { 82, 85, 65, 78, 0, 0 }, { 82, 85, 73, 0, 0, 0 }, { 82, 85, 78, 0, 0, 0 }, arrayOfByte146, arrayOfByte147, arrayOfByte148, arrayOfByte149, arrayOfByte150, { 83, 65, 79, 0, 0, 0 }, arrayOfByte151, { 83, 69, 78, 0, 0, 0 }, arrayOfByte152, arrayOfByte153, { 83, 72, 65, 73, 0, 0 }, { 83, 72, 65, 78, 0, 0 }, { 83, 72, 65, 78, 71, 0 }, arrayOfByte154, arrayOfByte155, arrayOfByte156, arrayOfByte157, arrayOfByte158, { 83, 72, 69, 78, 71, 0 }, arrayOfByte159, { 83, 72, 79, 85, 0, 0 }, arrayOfByte160, arrayOfByte161, arrayOfByte162, arrayOfByte163, arrayOfByte164, arrayOfByte165, { 83, 72, 85, 78, 0, 0 }, { 83, 72, 85, 79, 0, 0 }, arrayOfByte166, arrayOfByte167, arrayOfByte168, arrayOfByte169, { 83, 85, 65, 78, 0, 0 }, arrayOfByte170, arrayOfByte171, { 83, 85, 79, 0, 0, 0 }, arrayOfByte172, { 84, 65, 73, 0, 0, 0 }, { 84, 65, 78, 0, 0, 0 }, { 84, 65, 78, 71, 0, 0 }, arrayOfByte173, arrayOfByte174, arrayOfByte175, arrayOfByte176, { 84, 73, 65, 78, 0, 0 }, { 84, 73, 65, 79, 0, 0 }, arrayOfByte177, { 84, 73, 78, 71, 0, 0 }, arrayOfByte178, { 84, 79, 85, 0, 0, 0 }, arrayOfByte179, { 84, 85, 65, 78, 0, 0 }, { 84, 85, 73, 0, 0, 0 }, { 84, 85, 78, 0, 0, 0 }, { 84, 85, 79, 0, 0, 0 }, { 87, 65, 0, 0, 0, 0 }, arrayOfByte180, arrayOfByte181, arrayOfByte182, { 87, 69, 73, 0, 0, 0 }, arrayOfByte183, arrayOfByte184, arrayOfByte185, { 87, 85, 0, 0, 0, 0 }, { 88, 73, 0, 0, 0, 0 }, { 88, 73, 65, 0, 0, 0 }, arrayOfByte186, { 88, 73, 65, 78, 71, 0 }, arrayOfByte187, { 88, 73, 69, 0, 0, 0 }, arrayOfByte188, { 88, 73, 78, 71, 0, 0 }, arrayOfByte189, arrayOfByte190, { 88, 85, 0, 0, 0, 0 }, arrayOfByte191, { 88, 85, 69, 0, 0, 0 }, arrayOfByte192, arrayOfByte193, arrayOfByte194, { 89, 65, 78, 71, 0, 0 }, arrayOfByte195, { 89, 69, 0, 0, 0, 0 }, { 89, 73, 0, 0, 0, 0 }, arrayOfByte196, { 89, 73, 78, 71, 0, 0 }, { 89, 79, 0, 0, 0, 0 }, { 89, 79, 78, 71, 0, 0 }, arrayOfByte197, { 89, 85, 0, 0, 0, 0 }, arrayOfByte198, { 89, 85, 69, 0, 0, 0 }, { 89, 85, 78, 0, 0, 0 }, { 74, 85, 78, 0, 0, 0 }, arrayOfByte199, { 90, 65, 0, 0, 0, 0 }, { 90, 65, 73, 0, 0, 0 }, { 90, 65, 78, 0, 0, 0 }, { 90, 65, 78, 71, 0, 0 }, arrayOfByte200, { 90, 69, 0, 0, 0, 0 }, arrayOfByte201, { 90, 69, 78, 0, 0, 0 }, arrayOfByte202, { 90, 72, 65, 0, 0, 0 }, arrayOfByte203, { 90, 72, 65, 78, 0, 0 }, { 90, 72, 65, 78, 71, 0 }, arrayOfByte204, { 90, 72, 65, 78, 71, 0 }, arrayOfByte205, arrayOfByte206, arrayOfByte207, { 90, 72, 69, 78, 71, 0 }, { 90, 72, 73, 0, 0, 0 }, arrayOfByte208, { 90, 72, 73, 0, 0, 0 }, arrayOfByte209, arrayOfByte210, { 90, 72, 85, 0, 0, 0 }, { 90, 72, 85, 65, 0, 0 }, arrayOfByte211, arrayOfByte212, arrayOfByte213, { 90, 72, 85, 73, 0, 0 }, { 90, 72, 85, 78, 0, 0 }, arrayOfByte214, { 90, 73, 0, 0, 0, 0 }, { 90, 79, 78, 71, 0, 0 }, arrayOfByte215, arrayOfByte216, { 90, 85, 65, 78, 0, 0 }, arrayOfByte217, { 90, 85, 78, 0, 0, 0 }, arrayOfByte218, { 0, 0, 0, 0, 0, 0 }, { 83, 72, 65, 78, 0, 0 }, { 0, 0, 0, 0, 0, 0 } };
  }
  
  protected g(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }
  
  private a a(char paramChar)
  {
    a locala = new a();
    Object localObject = Character.toString(paramChar);
    locala.f = ((String)localObject);
    int j = -1;
    if (paramChar < 'Ā')
    {
      locala.e = 1;
      locala.g = ((String)localObject);
    }
    do
    {
      return locala;
      int k = g.compare((String)localObject, "阿");
      if (k < 0)
      {
        locala.e = 3;
        locala.g = ((String)localObject);
        return locala;
      }
      int n;
      int m;
      int i2;
      int i1;
      if (k == 0)
      {
        locala.e = 2;
        j = 0;
        locala.e = 2;
        n = k;
        m = j;
        if (j < 0)
        {
          i2 = 0;
          i1 = a.length - 1;
        }
      }
      for (;;)
      {
        n = k;
        m = j;
        if (i2 <= i1)
        {
          j = (i2 + i1) / 2;
          String str = Character.toString(a[j]);
          k = g.compare((String)localObject, str);
          if (k == 0)
          {
            m = j;
            n = k;
          }
        }
        else
        {
          j = m;
          if (n < 0) {
            j = m - 1;
          }
          localObject = new StringBuilder();
          k = 0;
          while ((k < b[j].length) && (b[j][k] != 0))
          {
            ((StringBuilder)localObject).append((char)b[j][k]);
            k += 1;
          }
          m = g.compare((String)localObject, "鿿");
          if (m > 0)
          {
            locala.e = 3;
            locala.g = ((String)localObject);
            return locala;
          }
          k = m;
          if (m != 0) {
            break;
          }
          locala.e = 2;
          j = a.length - 1;
          k = m;
          break;
        }
        if (k > 0) {
          i2 = j + 1;
        } else {
          i1 = j - 1;
        }
      }
      locala.g = ((StringBuilder)localObject).toString();
    } while (!TextUtils.isEmpty(locala.g));
    locala.e = 3;
    locala.g = locala.f;
    return locala;
  }
  
  public static g a()
  {
    if (h == null) {
      h = new g(true);
    }
    return h;
  }
  
  private void a(StringBuilder paramStringBuilder, ArrayList<a> paramArrayList, int paramInt)
  {
    String str = paramStringBuilder.toString();
    paramArrayList.add(new a(paramInt, str, str));
    paramStringBuilder.setLength(0);
  }
  
  private static boolean b()
  {
    char c1 = a[0];
    Object localObject = Character.toString(c1);
    char[] arrayOfChar = a;
    int k = arrayOfChar.length;
    int j = 0;
    if (j < k)
    {
      char c2 = arrayOfChar[j];
      if (c1 == c2) {}
      for (;;)
      {
        j += 1;
        break;
        String str = Character.toString(c2);
        if (g.compare((String)localObject, str) >= 0)
        {
          h.e("HanziToPinyin", "Internal error in Unihan table. The last string \"" + (String)localObject + "\" is greater than current string \"" + str + "\".");
          return false;
        }
        localObject = str;
      }
    }
    return true;
  }
  
  public ArrayList<a> a(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    if ((!this.i) || (TextUtils.isEmpty(paramString))) {}
    StringBuilder localStringBuilder;
    int m;
    do
    {
      return localArrayList;
      int n = paramString.length();
      localStringBuilder = new StringBuilder();
      m = 1;
      int k = 0;
      if (k < n)
      {
        char c1 = paramString.charAt(k);
        int j;
        if (c1 == ' ')
        {
          j = m;
          if (localStringBuilder.length() > 0)
          {
            a(localStringBuilder, localArrayList, m);
            j = m;
          }
        }
        for (;;)
        {
          k += 1;
          m = j;
          break;
          if (c1 < 'Ā')
          {
            if ((m != 1) && (localStringBuilder.length() > 0)) {
              a(localStringBuilder, localArrayList, m);
            }
            j = 1;
            localStringBuilder.append(c1);
          }
          else
          {
            a locala = a(c1);
            if (locala.e == 2)
            {
              if (localStringBuilder.length() > 0) {
                a(localStringBuilder, localArrayList, m);
              }
              localArrayList.add(locala);
              j = 2;
            }
            else
            {
              if ((m != locala.e) && (localStringBuilder.length() > 0)) {
                a(localStringBuilder, localArrayList, m);
              }
              j = locala.e;
              localStringBuilder.append(c1);
            }
          }
        }
      }
    } while (localStringBuilder.length() <= 0);
    a(localStringBuilder, localArrayList, m);
    return localArrayList;
  }
  
  public static class a
  {
    public static final String a = " ";
    public static final int b = 1;
    public static final int c = 2;
    public static final int d = 3;
    public int e;
    public String f;
    public String g;
    
    public a() {}
    
    public a(int paramInt, String paramString1, String paramString2)
    {
      this.e = paramInt;
      this.f = paramString1;
      this.g = paramString2;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/util/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */