package com.baidu.tts.client.model;

import com.baidu.tts.tools.StringTool;
import java.util.HashSet;
import java.util.Set;

public class AvailableConditions {
    /* renamed from: a */
    private Set<String> f20840a;
    /* renamed from: b */
    private Set<String> f20841b;

    public Set<String> getGenders() {
        return this.f20840a;
    }

    public void setGenders(Set<String> genders) {
        this.f20840a = genders;
    }

    public Set<String> getSpeakers() {
        return this.f20841b;
    }

    public void setSpeakers(Set<String> speakers) {
        this.f20841b = speakers;
    }

    public void appendGender(String gender) {
        if (!StringTool.isEmpty(gender)) {
            if (this.f20840a == null) {
                this.f20840a = new HashSet();
            }
            this.f20840a.add(gender);
        }
    }

    public void appendSpeaker(String speaker) {
        if (!StringTool.isEmpty(speaker)) {
            if (this.f20841b == null) {
                this.f20841b = new HashSet();
            }
            this.f20841b.add(speaker);
        }
    }
}
