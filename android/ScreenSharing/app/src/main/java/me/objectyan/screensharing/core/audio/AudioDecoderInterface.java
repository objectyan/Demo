package me.objectyan.screensharing.core.audio;

import java.util.ArrayList;


public interface AudioDecoderInterface {

    int getSampleRate();


    int changeOutput(Pair pair, int i);


    int decodeAudio(String str);


    int initialization(String str, ArrayList arrayList);


    int getChannelConfig();


    int getReSampleRate();
}
