package com.baidu.che.codriver.protocol.data.nlp;

import android.text.TextUtils;
import com.baidu.che.codriver.util.INoProguard;
import com.google.gson.annotations.SerializedName;

public class Slots implements INoProguard {
    public String actor;
    @SerializedName("ask_confirm_pay")
    public String askConfirmPay;
    @SerializedName("ask_type")
    public String askType;
    @SerializedName("book_seat")
    public String bookSeat;
    public String cinema;
    @SerializedName("cinema_id")
    public String cinemaId;
    public String director;
    @SerializedName("end_time")
    public String endTime;
    @SerializedName("film_id")
    public String filmId;
    @SerializedName("film_info")
    public String filmInfo;
    @SerializedName("film_name")
    public String filmName;
    public String latitude;
    public String length;
    public String longitude;
    public String offset;
    @SerializedName("order_id")
    public String orderId;
    public String price;
    @SerializedName("seat_info")
    public String seatInfo;
    @SerializedName("sequence_id")
    public String sequenceId;
    @SerializedName("start_time")
    public String startTime;
    @SerializedName("theater_name")
    public String theaterName;
    @SerializedName("ticket_cnt")
    public String ticketCnt;
    @SerializedName("ticket_count")
    public String ticketCount;
    public String time;
    @SerializedName("time_info")
    public String timeInfo;

    public Slots setSlots(Slots mSlots, Slots slotsItem, BaseFilmData mData) {
        if (!TextUtils.isEmpty(mData.slots.askType)) {
            mSlots.askType = mData.slots.askType;
        }
        if (!TextUtils.isEmpty(mData.slots.filmId)) {
            mSlots.filmId = mData.slots.filmId;
        }
        if (!TextUtils.isEmpty(mData.slots.filmName)) {
            mSlots.filmName = mData.slots.filmName;
        }
        if (!TextUtils.isEmpty(mData.slots.cinema)) {
            mSlots.cinema = mData.slots.cinema;
        }
        if (!TextUtils.isEmpty(mData.slots.timeInfo)) {
            mSlots.timeInfo = mData.slots.timeInfo;
        }
        if (!TextUtils.isEmpty(mData.slots.filmInfo)) {
            mSlots.filmInfo = mData.slots.filmInfo;
        }
        if (!TextUtils.isEmpty(mData.slots.cinemaId)) {
            mSlots.cinemaId = mData.slots.cinemaId;
        }
        if (!TextUtils.isEmpty(mData.slots.length)) {
            mSlots.length = mData.slots.length;
        }
        if (!TextUtils.isEmpty(mData.slots.actor)) {
            mSlots.actor = mData.slots.actor;
        }
        if (!TextUtils.isEmpty(mData.slots.director)) {
            mSlots.director = mData.slots.director;
        }
        if (!TextUtils.isEmpty(mData.slots.time)) {
            mSlots.time = mData.slots.time;
        }
        if (!TextUtils.isEmpty(mData.slots.sequenceId)) {
            mSlots.sequenceId = mData.slots.sequenceId;
        }
        if (!TextUtils.isEmpty(mData.slots.ticketCount)) {
            mSlots.ticketCount = mData.slots.ticketCount;
        }
        if (!TextUtils.isEmpty(mData.slots.price)) {
            mSlots.price = mData.slots.price;
        }
        if (!TextUtils.isEmpty(mData.slots.bookSeat)) {
            mSlots.bookSeat = mData.slots.bookSeat;
        }
        if (!TextUtils.isEmpty(mData.slots.seatInfo)) {
            mSlots.seatInfo = mData.slots.seatInfo;
        }
        if (!TextUtils.isEmpty(mData.slots.orderId)) {
            mSlots.orderId = mData.slots.orderId;
        }
        if (!TextUtils.isEmpty(mData.slots.startTime)) {
            mSlots.startTime = mData.slots.startTime;
        }
        if (!TextUtils.isEmpty(mData.slots.endTime)) {
            mSlots.endTime = mData.slots.endTime;
        }
        if (!TextUtils.isEmpty(mData.slots.theaterName)) {
            mSlots.theaterName = mData.slots.theaterName;
        }
        if (!TextUtils.isEmpty(mData.slots.time)) {
            mSlots.time = mData.slots.time;
        }
        if (!TextUtils.isEmpty(mData.slots.latitude)) {
            mSlots.latitude = mData.slots.latitude;
        }
        if (!TextUtils.isEmpty(mData.slots.longitude)) {
            mSlots.longitude = mData.slots.longitude;
        }
        if (!TextUtils.isEmpty(mData.slots.ticketCnt) && Integer.valueOf(mData.slots.ticketCnt).intValue() <= 4) {
            mSlots.ticketCnt = mData.slots.ticketCnt;
        }
        if (slotsItem != null) {
            if (!TextUtils.isEmpty(slotsItem.askType)) {
                mSlots.askType = slotsItem.askType;
            }
            if (!TextUtils.isEmpty(slotsItem.timeInfo)) {
                mSlots.timeInfo = slotsItem.timeInfo;
            }
            if (!TextUtils.isEmpty(slotsItem.filmInfo)) {
                mSlots.filmInfo = slotsItem.filmInfo;
            }
            if (!TextUtils.isEmpty(slotsItem.filmId)) {
                mSlots.filmId = slotsItem.filmId;
            }
            if (!TextUtils.isEmpty(slotsItem.filmName)) {
                mSlots.filmName = slotsItem.filmName;
            }
            if (!TextUtils.isEmpty(slotsItem.cinema)) {
                mSlots.cinema = slotsItem.cinema;
            }
            if (!TextUtils.isEmpty(slotsItem.cinemaId)) {
                mSlots.cinemaId = slotsItem.cinemaId;
            }
            if (!TextUtils.isEmpty(slotsItem.length)) {
                mSlots.length = slotsItem.length;
            }
            if (!TextUtils.isEmpty(slotsItem.actor)) {
                mSlots.actor = slotsItem.actor;
            }
            if (!TextUtils.isEmpty(slotsItem.director)) {
                mSlots.director = slotsItem.director;
            }
            if (!TextUtils.isEmpty(slotsItem.time)) {
                mSlots.time = slotsItem.time;
            }
            if (!TextUtils.isEmpty(slotsItem.sequenceId)) {
                mSlots.sequenceId = slotsItem.sequenceId;
            }
            if (!TextUtils.isEmpty(slotsItem.ticketCount)) {
                mSlots.ticketCount = slotsItem.ticketCount;
            }
            if (!TextUtils.isEmpty(slotsItem.price)) {
                mSlots.price = slotsItem.price;
            }
            if (!TextUtils.isEmpty(slotsItem.bookSeat)) {
                mSlots.bookSeat = slotsItem.bookSeat;
            }
            if (!TextUtils.isEmpty(slotsItem.seatInfo)) {
                mSlots.seatInfo = slotsItem.seatInfo;
            }
            if (!TextUtils.isEmpty(slotsItem.orderId)) {
                mSlots.orderId = slotsItem.orderId;
            }
            if (!TextUtils.isEmpty(slotsItem.startTime)) {
                mSlots.startTime = slotsItem.startTime;
            }
            if (!TextUtils.isEmpty(slotsItem.endTime)) {
                mSlots.endTime = slotsItem.endTime;
            }
            if (!TextUtils.isEmpty(slotsItem.theaterName)) {
                mSlots.theaterName = slotsItem.theaterName;
            }
            if (!TextUtils.isEmpty(slotsItem.time)) {
                mSlots.time = slotsItem.time;
            }
            if (!TextUtils.isEmpty(slotsItem.latitude)) {
                mSlots.latitude = slotsItem.latitude;
            }
            if (!TextUtils.isEmpty(slotsItem.longitude)) {
                mSlots.longitude = slotsItem.longitude;
            }
        }
        return mSlots;
    }
}
