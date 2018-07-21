package com.baidu.carlife.core;

import android.text.TextUtils;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Locale;

public class g
  implements h
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
    byte[] arrayOfByte1 = { 65, 78, 0, 0, 0, 0 };
    byte[] arrayOfByte2 = { 66, 73, 69, 0, 0, 0 };
    byte[] arrayOfByte3 = { 66, 73, 78, 71, 0, 0 };
    byte[] arrayOfByte4 = { 66, 79, 0, 0, 0, 0 };
    byte[] arrayOfByte5 = { 67, 65, 0, 0, 0, 0 };
    byte[] arrayOfByte6 = { 67, 65, 78, 71, 0, 0 };
    byte[] arrayOfByte7 = { 67, 65, 79, 0, 0, 0 };
    byte[] arrayOfByte8 = { 67, 69, 78, 71, 0, 0 };
    byte[] arrayOfByte9 = { 67, 72, 65, 0, 0, 0 };
    byte[] arrayOfByte10 = { 67, 72, 69, 78, 0, 0 };
    byte[] arrayOfByte11 = { 67, 72, 69, 78, 71, 0 };
    byte[] arrayOfByte12 = { 67, 72, 73, 0, 0, 0 };
    byte[] arrayOfByte13 = { 67, 72, 85, 65, 0, 0 };
    byte[] arrayOfByte14 = { 67, 72, 85, 65, 78, 0 };
    byte[] arrayOfByte15 = { 67, 72, 85, 65, 78, 71 };
    byte[] arrayOfByte16 = { 67, 73, 0, 0, 0, 0 };
    byte[] arrayOfByte17 = { 67, 85, 65, 78, 0, 0 };
    byte[] arrayOfByte18 = { 67, 85, 73, 0, 0, 0 };
    byte[] arrayOfByte19 = { 68, 65, 78, 71, 0, 0 };
    byte[] arrayOfByte20 = { 68, 79, 78, 71, 0, 0 };
    byte[] arrayOfByte21 = { 68, 79, 85, 0, 0, 0 };
    byte[] arrayOfByte22 = { 69, 78, 71, 0, 0, 0 };
    byte[] arrayOfByte23 = { 69, 82, 0, 0, 0, 0 };
    byte[] arrayOfByte24 = { 70, 69, 73, 0, 0, 0 };
    byte[] arrayOfByte25 = { 70, 69, 78, 0, 0, 0 };
    byte[] arrayOfByte26 = { 70, 79, 0, 0, 0, 0 };
    byte[] arrayOfByte27 = { 70, 79, 85, 0, 0, 0 };
    byte[] arrayOfByte28 = { 71, 65, 73, 0, 0, 0 };
    byte[] arrayOfByte29 = { 71, 65, 79, 0, 0, 0 };
    byte[] arrayOfByte30 = { 71, 69, 78, 0, 0, 0 };
    byte[] arrayOfByte31 = { 72, 65, 0, 0, 0, 0 };
    byte[] arrayOfByte32 = { 72, 65, 73, 0, 0, 0 };
    byte[] arrayOfByte33 = { 72, 69, 78, 71, 0, 0 };
    byte[] arrayOfByte34 = { 72, 77, 0, 0, 0, 0 };
    byte[] arrayOfByte35 = { 72, 79, 78, 71, 0, 0 };
    byte[] arrayOfByte36 = { 72, 85, 65, 0, 0, 0 };
    byte[] arrayOfByte37 = { 72, 85, 78, 0, 0, 0 };
    byte[] arrayOfByte38 = { 74, 73, 0, 0, 0, 0 };
    byte[] arrayOfByte39 = { 74, 73, 65, 0, 0, 0 };
    byte[] arrayOfByte40 = { 74, 85, 0, 0, 0, 0 };
    byte[] arrayOfByte41 = { 74, 85, 69, 0, 0, 0 };
    byte[] arrayOfByte42 = { 75, 69, 0, 0, 0, 0 };
    byte[] arrayOfByte43 = { 75, 79, 78, 71, 0, 0 };
    byte[] arrayOfByte44 = { 75, 85, 79, 0, 0, 0 };
    byte[] arrayOfByte45 = { 76, 65, 0, 0, 0, 0 };
    byte[] arrayOfByte46 = { 76, 65, 78, 0, 0, 0 };
    byte[] arrayOfByte47 = { 76, 65, 78, 71, 0, 0 };
    byte[] arrayOfByte48 = { 76, 65, 79, 0, 0, 0 };
    byte[] arrayOfByte49 = { 76, 69, 78, 71, 0, 0 };
    byte[] arrayOfByte50 = { 76, 73, 65, 0, 0, 0 };
    byte[] arrayOfByte51 = { 76, 73, 78, 71, 0, 0 };
    byte[] arrayOfByte52 = { 76, 79, 85, 0, 0, 0 };
    byte[] arrayOfByte53 = { 76, 85, 69, 0, 0, 0 };
    byte[] arrayOfByte54 = { 76, 85, 78, 0, 0, 0 };
    byte[] arrayOfByte55 = { 77, 65, 78, 0, 0, 0 };
    byte[] arrayOfByte56 = { 77, 69, 73, 0, 0, 0 };
    byte[] arrayOfByte57 = { 77, 69, 78, 0, 0, 0 };
    byte[] arrayOfByte58 = { 77, 69, 78, 71, 0, 0 };
    byte[] arrayOfByte59 = { 77, 73, 65, 78, 0, 0 };
    byte[] arrayOfByte60 = { 77, 73, 78, 71, 0, 0 };
    byte[] arrayOfByte61 = { 77, 79, 0, 0, 0, 0 };
    byte[] arrayOfByte62 = { 78, 69, 0, 0, 0, 0 };
    byte[] arrayOfByte63 = { 78, 69, 73, 0, 0, 0 };
    byte[] arrayOfByte64 = { 78, 69, 78, 0, 0, 0 };
    byte[] arrayOfByte65 = { 78, 69, 78, 71, 0, 0 };
    byte[] arrayOfByte66 = { 78, 73, 65, 79, 0, 0 };
    byte[] arrayOfByte67 = { 78, 73, 78, 71, 0, 0 };
    byte[] arrayOfByte68 = { 78, 79, 78, 71, 0, 0 };
    byte[] arrayOfByte69 = { 78, 85, 0, 0, 0, 0 };
    byte[] arrayOfByte70 = { 80, 65, 0, 0, 0, 0 };
    byte[] arrayOfByte71 = { 80, 69, 78, 0, 0, 0 };
    byte[] arrayOfByte72 = { 80, 73, 65, 78, 0, 0 };
    byte[] arrayOfByte73 = { 80, 73, 65, 79, 0, 0 };
    byte[] arrayOfByte74 = { 81, 73, 0, 0, 0, 0 };
    byte[] arrayOfByte75 = { 81, 73, 65, 78, 0, 0 };
    byte[] arrayOfByte76 = { 81, 73, 65, 78, 71, 0 };
    byte[] arrayOfByte77 = { 81, 73, 65, 79, 0, 0 };
    byte[] arrayOfByte78 = { 81, 73, 69, 0, 0, 0 };
    byte[] arrayOfByte79 = { 81, 73, 78, 0, 0, 0 };
    byte[] arrayOfByte80 = { 81, 73, 79, 78, 71, 0 };
    byte[] arrayOfByte81 = { 81, 85, 69, 0, 0, 0 };
    byte[] arrayOfByte82 = { 81, 85, 78, 0, 0, 0 };
    byte[] arrayOfByte83 = { 82, 69, 78, 0, 0, 0 };
    byte[] arrayOfByte84 = { 82, 73, 0, 0, 0, 0 };
    byte[] arrayOfByte85 = { 82, 85, 0, 0, 0, 0 };
    byte[] arrayOfByte86 = { 83, 65, 73, 0, 0, 0 };
    byte[] arrayOfByte87 = { 83, 65, 78, 71, 0, 0 };
    byte[] arrayOfByte88 = { 83, 69, 0, 0, 0, 0 };
    byte[] arrayOfByte89 = { 83, 69, 78, 0, 0, 0 };
    byte[] arrayOfByte90 = { 83, 72, 65, 73, 0, 0 };
    byte[] arrayOfByte91 = { 83, 72, 65, 78, 0, 0 };
    byte[] arrayOfByte92 = { 83, 72, 69, 78, 0, 0 };
    byte[] arrayOfByte93 = { 83, 72, 73, 0, 0, 0 };
    byte[] arrayOfByte94 = { 83, 72, 79, 85, 0, 0 };
    byte[] arrayOfByte95 = { 83, 72, 85, 0, 0, 0 };
    byte[] arrayOfByte96 = { 83, 72, 85, 65, 0, 0 };
    byte[] arrayOfByte97 = { 83, 72, 85, 73, 0, 0 };
    byte[] arrayOfByte98 = { 83, 79, 85, 0, 0, 0 };
    byte[] arrayOfByte99 = { 83, 85, 65, 78, 0, 0 };
    byte[] arrayOfByte100 = { 83, 85, 73, 0, 0, 0 };
    byte[] arrayOfByte101 = { 83, 85, 79, 0, 0, 0 };
    byte[] arrayOfByte102 = { 84, 65, 0, 0, 0, 0 };
    byte[] arrayOfByte103 = { 84, 65, 73, 0, 0, 0 };
    byte[] arrayOfByte104 = { 84, 65, 79, 0, 0, 0 };
    byte[] arrayOfByte105 = { 84, 73, 65, 78, 0, 0 };
    byte[] arrayOfByte106 = { 87, 65, 0, 0, 0, 0 };
    byte[] arrayOfByte107 = { 87, 85, 0, 0, 0, 0 };
    byte[] arrayOfByte108 = { 88, 73, 65, 0, 0, 0 };
    byte[] arrayOfByte109 = { 88, 73, 79, 78, 71, 0 };
    byte[] arrayOfByte110 = { 88, 85, 78, 0, 0, 0 };
    byte[] arrayOfByte111 = { 89, 65, 79, 0, 0, 0 };
    byte[] arrayOfByte112 = { 89, 69, 0, 0, 0, 0 };
    byte[] arrayOfByte113 = { 89, 73, 78, 71, 0, 0 };
    byte[] arrayOfByte114 = { 89, 79, 85, 0, 0, 0 };
    byte[] arrayOfByte115 = { 89, 85, 65, 78, 0, 0 };
    byte[] arrayOfByte116 = { 89, 85, 69, 0, 0, 0 };
    byte[] arrayOfByte117 = { 89, 85, 78, 0, 0, 0 };
    byte[] arrayOfByte118 = { 89, 85, 78, 0, 0, 0 };
    byte[] arrayOfByte119 = { 90, 69, 78, 0, 0, 0 };
    byte[] arrayOfByte120 = { 90, 72, 65, 78, 71, 0 };
    byte[] arrayOfByte121 = { 67, 72, 65, 78, 71, 0 };
    byte[] arrayOfByte122 = { 90, 72, 69, 0, 0, 0 };
    byte[] arrayOfByte123 = { 90, 72, 69, 78, 71, 0 };
    byte[] arrayOfByte124 = { 90, 72, 79, 78, 71, 0 };
    byte[] arrayOfByte125 = { 90, 72, 85, 73, 0, 0 };
    byte[] arrayOfByte126 = { 90, 72, 85, 79, 0, 0 };
    byte[] arrayOfByte127 = { 90, 85, 0, 0, 0, 0 };
    byte[] arrayOfByte128 = { 90, 85, 73, 0, 0, 0 };
    byte[] arrayOfByte129 = { 0, 0, 0, 0, 0, 0 };
    b = new byte[][] { { 65, 0, 0, 0, 0, 0 }, { 65, 73, 0, 0, 0, 0 }, arrayOfByte1, { 65, 78, 71, 0, 0, 0 }, { 65, 79, 0, 0, 0, 0 }, { 66, 65, 0, 0, 0, 0 }, { 66, 65, 73, 0, 0, 0 }, { 66, 65, 78, 0, 0, 0 }, { 66, 65, 78, 71, 0, 0 }, { 66, 65, 79, 0, 0, 0 }, { 66, 69, 73, 0, 0, 0 }, { 66, 69, 78, 0, 0, 0 }, { 66, 69, 78, 71, 0, 0 }, { 66, 73, 0, 0, 0, 0 }, { 66, 73, 65, 78, 0, 0 }, { 66, 73, 65, 79, 0, 0 }, arrayOfByte2, { 66, 73, 78, 0, 0, 0 }, arrayOfByte3, arrayOfByte4, { 66, 85, 0, 0, 0, 0 }, arrayOfByte5, { 67, 65, 73, 0, 0, 0 }, { 67, 65, 78, 0, 0, 0 }, arrayOfByte6, arrayOfByte7, { 67, 69, 0, 0, 0, 0 }, { 67, 69, 78, 0, 0, 0 }, { 67, 69, 78, 71, 0, 0 }, { 90, 69, 78, 71, 0, 0 }, arrayOfByte8, arrayOfByte9, { 67, 72, 65, 73, 0, 0 }, { 67, 72, 65, 78, 0, 0 }, { 67, 72, 65, 78, 71, 0 }, { 67, 72, 65, 79, 0, 0 }, { 67, 72, 69, 0, 0, 0 }, { 67, 72, 69, 78, 0, 0 }, { 83, 72, 69, 78, 0, 0 }, arrayOfByte10, arrayOfByte11, arrayOfByte12, { 67, 72, 79, 78, 71, 0 }, { 67, 72, 79, 85, 0, 0 }, { 67, 72, 85, 0, 0, 0 }, arrayOfByte13, { 67, 72, 85, 65, 73, 0 }, arrayOfByte14, arrayOfByte15, { 67, 72, 85, 73, 0, 0 }, { 67, 72, 85, 78, 0, 0 }, { 67, 72, 85, 79, 0, 0 }, arrayOfByte16, { 67, 79, 78, 71, 0, 0 }, { 67, 79, 85, 0, 0, 0 }, { 67, 85, 0, 0, 0, 0 }, arrayOfByte17, arrayOfByte18, { 67, 85, 78, 0, 0, 0 }, { 67, 85, 79, 0, 0, 0 }, { 68, 65, 0, 0, 0, 0 }, { 68, 65, 73, 0, 0, 0 }, { 68, 65, 78, 0, 0, 0 }, arrayOfByte19, { 68, 65, 79, 0, 0, 0 }, { 68, 69, 0, 0, 0, 0 }, { 68, 69, 78, 0, 0, 0 }, { 68, 69, 78, 71, 0, 0 }, { 68, 73, 0, 0, 0, 0 }, { 68, 73, 65, 0, 0, 0 }, { 68, 73, 65, 78, 0, 0 }, { 68, 73, 65, 79, 0, 0 }, { 68, 73, 69, 0, 0, 0 }, { 68, 73, 78, 71, 0, 0 }, { 68, 73, 85, 0, 0, 0 }, arrayOfByte20, arrayOfByte21, { 68, 85, 0, 0, 0, 0 }, { 68, 85, 65, 78, 0, 0 }, { 68, 85, 73, 0, 0, 0 }, { 68, 85, 78, 0, 0, 0 }, { 68, 85, 79, 0, 0, 0 }, { 69, 0, 0, 0, 0, 0 }, { 69, 73, 0, 0, 0, 0 }, { 69, 78, 0, 0, 0, 0 }, arrayOfByte22, arrayOfByte23, { 70, 65, 0, 0, 0, 0 }, { 70, 65, 78, 0, 0, 0 }, { 70, 65, 78, 71, 0, 0 }, arrayOfByte24, arrayOfByte25, { 70, 69, 78, 71, 0, 0 }, { 70, 73, 65, 79, 0, 0 }, arrayOfByte26, arrayOfByte27, { 70, 85, 0, 0, 0, 0 }, { 71, 65, 0, 0, 0, 0 }, arrayOfByte28, { 71, 65, 78, 0, 0, 0 }, { 71, 65, 78, 71, 0, 0 }, arrayOfByte29, { 71, 69, 0, 0, 0, 0 }, { 71, 69, 73, 0, 0, 0 }, arrayOfByte30, { 71, 69, 78, 71, 0, 0 }, { 71, 79, 78, 71, 0, 0 }, { 71, 79, 85, 0, 0, 0 }, { 71, 85, 0, 0, 0, 0 }, { 71, 85, 65, 0, 0, 0 }, { 71, 85, 65, 73, 0, 0 }, { 71, 85, 65, 78, 0, 0 }, { 71, 85, 65, 78, 71, 0 }, { 71, 85, 73, 0, 0, 0 }, { 71, 85, 78, 0, 0, 0 }, { 71, 85, 79, 0, 0, 0 }, arrayOfByte31, arrayOfByte32, { 72, 65, 78, 0, 0, 0 }, { 72, 65, 78, 71, 0, 0 }, { 72, 65, 79, 0, 0, 0 }, { 72, 69, 0, 0, 0, 0 }, { 72, 69, 73, 0, 0, 0 }, { 72, 69, 78, 0, 0, 0 }, arrayOfByte33, arrayOfByte34, arrayOfByte35, { 72, 79, 85, 0, 0, 0 }, { 72, 85, 0, 0, 0, 0 }, arrayOfByte36, { 72, 85, 65, 73, 0, 0 }, { 72, 85, 65, 78, 0, 0 }, { 72, 85, 65, 78, 71, 0 }, { 72, 85, 73, 0, 0, 0 }, arrayOfByte37, { 72, 85, 79, 0, 0, 0 }, arrayOfByte38, arrayOfByte39, { 74, 73, 65, 78, 0, 0 }, { 74, 73, 65, 78, 71, 0 }, { 74, 73, 65, 79, 0, 0 }, { 74, 73, 69, 0, 0, 0 }, { 74, 73, 78, 0, 0, 0 }, { 74, 73, 78, 71, 0, 0 }, { 74, 73, 79, 78, 71, 0 }, { 74, 73, 85, 0, 0, 0 }, arrayOfByte40, { 74, 85, 65, 78, 0, 0 }, arrayOfByte41, { 74, 85, 78, 0, 0, 0 }, { 75, 65, 0, 0, 0, 0 }, { 75, 65, 73, 0, 0, 0 }, { 75, 65, 78, 0, 0, 0 }, { 75, 65, 78, 71, 0, 0 }, { 75, 65, 79, 0, 0, 0 }, arrayOfByte42, { 75, 69, 78, 0, 0, 0 }, { 75, 69, 78, 71, 0, 0 }, arrayOfByte43, { 75, 79, 85, 0, 0, 0 }, { 75, 85, 0, 0, 0, 0 }, { 75, 85, 65, 0, 0, 0 }, { 75, 85, 65, 73, 0, 0 }, { 75, 85, 65, 78, 0, 0 }, { 75, 85, 65, 78, 71, 0 }, { 75, 85, 73, 0, 0, 0 }, { 75, 85, 78, 0, 0, 0 }, arrayOfByte44, arrayOfByte45, { 76, 65, 73, 0, 0, 0 }, arrayOfByte46, arrayOfByte47, arrayOfByte48, { 76, 69, 0, 0, 0, 0 }, { 76, 69, 73, 0, 0, 0 }, arrayOfByte49, { 76, 73, 0, 0, 0, 0 }, arrayOfByte50, { 76, 73, 65, 78, 0, 0 }, { 76, 73, 65, 78, 71, 0 }, { 76, 73, 65, 79, 0, 0 }, { 76, 73, 69, 0, 0, 0 }, { 76, 73, 78, 0, 0, 0 }, arrayOfByte51, { 76, 73, 85, 0, 0, 0 }, { 76, 79, 0, 0, 0, 0 }, { 76, 79, 78, 71, 0, 0 }, arrayOfByte52, { 76, 85, 0, 0, 0, 0 }, { 76, 85, 65, 78, 0, 0 }, arrayOfByte53, arrayOfByte54, { 76, 85, 79, 0, 0, 0 }, { 77, 0, 0, 0, 0, 0 }, { 77, 65, 0, 0, 0, 0 }, { 77, 65, 73, 0, 0, 0 }, arrayOfByte55, { 77, 65, 78, 71, 0, 0 }, { 77, 65, 79, 0, 0, 0 }, { 77, 69, 0, 0, 0, 0 }, arrayOfByte56, arrayOfByte57, arrayOfByte58, { 77, 73, 0, 0, 0, 0 }, arrayOfByte59, { 77, 73, 65, 79, 0, 0 }, { 77, 73, 69, 0, 0, 0 }, { 77, 73, 78, 0, 0, 0 }, arrayOfByte60, { 77, 73, 85, 0, 0, 0 }, arrayOfByte61, { 77, 79, 85, 0, 0, 0 }, { 77, 85, 0, 0, 0, 0 }, { 78, 0, 0, 0, 0, 0 }, { 78, 65, 0, 0, 0, 0 }, { 78, 65, 73, 0, 0, 0 }, { 78, 65, 78, 0, 0, 0 }, { 78, 65, 78, 71, 0, 0 }, { 78, 65, 79, 0, 0, 0 }, arrayOfByte62, arrayOfByte63, arrayOfByte64, arrayOfByte65, { 78, 73, 0, 0, 0, 0 }, { 78, 73, 65, 78, 0, 0 }, { 78, 73, 65, 78, 71, 0 }, arrayOfByte66, { 78, 73, 69, 0, 0, 0 }, { 78, 73, 78, 0, 0, 0 }, arrayOfByte67, { 78, 73, 85, 0, 0, 0 }, arrayOfByte68, { 78, 79, 85, 0, 0, 0 }, arrayOfByte69, { 78, 85, 65, 78, 0, 0 }, { 78, 85, 69, 0, 0, 0 }, { 78, 85, 78, 0, 0, 0 }, { 78, 85, 79, 0, 0, 0 }, { 79, 0, 0, 0, 0, 0 }, { 79, 85, 0, 0, 0, 0 }, arrayOfByte70, { 80, 65, 73, 0, 0, 0 }, { 80, 65, 78, 0, 0, 0 }, { 80, 65, 78, 71, 0, 0 }, { 80, 65, 79, 0, 0, 0 }, { 80, 69, 73, 0, 0, 0 }, arrayOfByte71, { 80, 69, 78, 71, 0, 0 }, { 80, 73, 0, 0, 0, 0 }, arrayOfByte72, arrayOfByte73, { 80, 73, 69, 0, 0, 0 }, { 80, 73, 78, 0, 0, 0 }, { 80, 73, 78, 71, 0, 0 }, { 80, 79, 0, 0, 0, 0 }, { 80, 79, 85, 0, 0, 0 }, { 80, 85, 0, 0, 0, 0 }, arrayOfByte74, { 81, 73, 65, 0, 0, 0 }, arrayOfByte75, arrayOfByte76, arrayOfByte77, arrayOfByte78, arrayOfByte79, { 81, 73, 78, 71, 0, 0 }, arrayOfByte80, { 81, 73, 85, 0, 0, 0 }, { 81, 85, 0, 0, 0, 0 }, { 81, 85, 65, 78, 0, 0 }, arrayOfByte81, arrayOfByte82, { 82, 65, 78, 0, 0, 0 }, { 82, 65, 78, 71, 0, 0 }, { 82, 65, 79, 0, 0, 0 }, { 82, 69, 0, 0, 0, 0 }, arrayOfByte83, { 82, 69, 78, 71, 0, 0 }, arrayOfByte84, { 82, 79, 78, 71, 0, 0 }, { 82, 79, 85, 0, 0, 0 }, arrayOfByte85, { 82, 85, 65, 0, 0, 0 }, { 82, 85, 65, 78, 0, 0 }, { 82, 85, 73, 0, 0, 0 }, { 82, 85, 78, 0, 0, 0 }, { 82, 85, 79, 0, 0, 0 }, { 83, 65, 0, 0, 0, 0 }, arrayOfByte86, { 83, 65, 78, 0, 0, 0 }, arrayOfByte87, { 83, 65, 79, 0, 0, 0 }, arrayOfByte88, arrayOfByte89, { 83, 69, 78, 71, 0, 0 }, { 83, 72, 65, 0, 0, 0 }, arrayOfByte90, arrayOfByte91, { 83, 72, 65, 78, 71, 0 }, { 83, 72, 65, 79, 0, 0 }, { 83, 72, 69, 0, 0, 0 }, { 83, 72, 69, 78, 0, 0 }, { 88, 73, 78, 0, 0, 0 }, arrayOfByte92, { 83, 72, 69, 78, 71, 0 }, arrayOfByte93, arrayOfByte94, arrayOfByte95, arrayOfByte96, { 83, 72, 85, 65, 73, 0 }, { 83, 72, 85, 65, 78, 0 }, { 83, 72, 85, 65, 78, 71 }, arrayOfByte97, { 83, 72, 85, 78, 0, 0 }, { 83, 72, 85, 79, 0, 0 }, { 83, 73, 0, 0, 0, 0 }, { 83, 79, 78, 71, 0, 0 }, arrayOfByte98, { 83, 85, 0, 0, 0, 0 }, arrayOfByte99, arrayOfByte100, { 83, 85, 78, 0, 0, 0 }, arrayOfByte101, arrayOfByte102, arrayOfByte103, { 84, 65, 78, 0, 0, 0 }, { 84, 65, 78, 71, 0, 0 }, arrayOfByte104, { 84, 69, 0, 0, 0, 0 }, { 84, 69, 78, 71, 0, 0 }, { 84, 73, 0, 0, 0, 0 }, arrayOfByte105, { 84, 73, 65, 79, 0, 0 }, { 84, 73, 69, 0, 0, 0 }, { 84, 73, 78, 71, 0, 0 }, { 84, 79, 78, 71, 0, 0 }, { 84, 79, 85, 0, 0, 0 }, { 84, 85, 0, 0, 0, 0 }, { 84, 85, 65, 78, 0, 0 }, { 84, 85, 73, 0, 0, 0 }, { 84, 85, 78, 0, 0, 0 }, { 84, 85, 79, 0, 0, 0 }, arrayOfByte106, { 87, 65, 73, 0, 0, 0 }, { 87, 65, 78, 0, 0, 0 }, { 87, 65, 78, 71, 0, 0 }, { 87, 69, 73, 0, 0, 0 }, { 87, 69, 78, 0, 0, 0 }, { 87, 69, 78, 71, 0, 0 }, { 87, 79, 0, 0, 0, 0 }, arrayOfByte107, { 88, 73, 0, 0, 0, 0 }, arrayOfByte108, { 88, 73, 65, 78, 0, 0 }, { 88, 73, 65, 78, 71, 0 }, { 88, 73, 65, 79, 0, 0 }, { 88, 73, 69, 0, 0, 0 }, { 88, 73, 78, 0, 0, 0 }, { 88, 73, 78, 71, 0, 0 }, arrayOfByte109, { 88, 73, 85, 0, 0, 0 }, { 88, 85, 0, 0, 0, 0 }, { 88, 85, 65, 78, 0, 0 }, { 88, 85, 69, 0, 0, 0 }, arrayOfByte110, { 89, 65, 0, 0, 0, 0 }, { 89, 65, 78, 0, 0, 0 }, { 89, 65, 78, 71, 0, 0 }, arrayOfByte111, arrayOfByte112, { 89, 73, 0, 0, 0, 0 }, { 89, 73, 78, 0, 0, 0 }, arrayOfByte113, { 89, 79, 0, 0, 0, 0 }, { 89, 79, 78, 71, 0, 0 }, arrayOfByte114, { 89, 85, 0, 0, 0, 0 }, arrayOfByte115, arrayOfByte116, arrayOfByte117, { 74, 85, 78, 0, 0, 0 }, arrayOfByte118, { 90, 65, 0, 0, 0, 0 }, { 90, 65, 73, 0, 0, 0 }, { 90, 65, 78, 0, 0, 0 }, { 90, 65, 78, 71, 0, 0 }, { 90, 65, 79, 0, 0, 0 }, { 90, 69, 0, 0, 0, 0 }, { 90, 69, 73, 0, 0, 0 }, arrayOfByte119, { 90, 69, 78, 71, 0, 0 }, { 90, 72, 65, 0, 0, 0 }, { 90, 72, 65, 73, 0, 0 }, { 90, 72, 65, 78, 0, 0 }, arrayOfByte120, arrayOfByte121, { 90, 72, 65, 78, 71, 0 }, { 90, 72, 65, 79, 0, 0 }, arrayOfByte122, { 90, 72, 69, 78, 0, 0 }, arrayOfByte123, { 90, 72, 73, 0, 0, 0 }, { 83, 72, 73, 0, 0, 0 }, { 90, 72, 73, 0, 0, 0 }, arrayOfByte124, { 90, 72, 79, 85, 0, 0 }, { 90, 72, 85, 0, 0, 0 }, { 90, 72, 85, 65, 0, 0 }, { 90, 72, 85, 65, 73, 0 }, { 90, 72, 85, 65, 78, 0 }, { 90, 72, 85, 65, 78, 71 }, arrayOfByte125, { 90, 72, 85, 78, 0, 0 }, arrayOfByte126, { 90, 73, 0, 0, 0, 0 }, { 90, 79, 78, 71, 0, 0 }, { 90, 79, 85, 0, 0, 0 }, arrayOfByte127, { 90, 85, 65, 78, 0, 0 }, arrayOfByte128, { 90, 85, 78, 0, 0, 0 }, { 90, 85, 79, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 }, { 83, 72, 65, 78, 0, 0 }, arrayOfByte129 };
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
          i.e("HanziToPinyin", "Internal error in Unihan table. The last string \"" + (String)localObject + "\" is greater than current string \"" + str + "\".");
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


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/core/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */