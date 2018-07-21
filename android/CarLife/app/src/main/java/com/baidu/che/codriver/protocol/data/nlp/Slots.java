package com.baidu.che.codriver.protocol.data.nlp;

import android.text.TextUtils;
import com.baidu.che.codriver.util.INoProguard;
import com.google.gson.annotations.SerializedName;

public class Slots
  implements INoProguard
{
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
  
  public Slots setSlots(Slots paramSlots1, Slots paramSlots2, BaseFilmData paramBaseFilmData)
  {
    if (!TextUtils.isEmpty(paramBaseFilmData.slots.askType)) {
      paramSlots1.askType = paramBaseFilmData.slots.askType;
    }
    if (!TextUtils.isEmpty(paramBaseFilmData.slots.filmId)) {
      paramSlots1.filmId = paramBaseFilmData.slots.filmId;
    }
    if (!TextUtils.isEmpty(paramBaseFilmData.slots.filmName)) {
      paramSlots1.filmName = paramBaseFilmData.slots.filmName;
    }
    if (!TextUtils.isEmpty(paramBaseFilmData.slots.cinema)) {
      paramSlots1.cinema = paramBaseFilmData.slots.cinema;
    }
    if (!TextUtils.isEmpty(paramBaseFilmData.slots.timeInfo)) {
      paramSlots1.timeInfo = paramBaseFilmData.slots.timeInfo;
    }
    if (!TextUtils.isEmpty(paramBaseFilmData.slots.filmInfo)) {
      paramSlots1.filmInfo = paramBaseFilmData.slots.filmInfo;
    }
    if (!TextUtils.isEmpty(paramBaseFilmData.slots.cinemaId)) {
      paramSlots1.cinemaId = paramBaseFilmData.slots.cinemaId;
    }
    if (!TextUtils.isEmpty(paramBaseFilmData.slots.length)) {
      paramSlots1.length = paramBaseFilmData.slots.length;
    }
    if (!TextUtils.isEmpty(paramBaseFilmData.slots.actor)) {
      paramSlots1.actor = paramBaseFilmData.slots.actor;
    }
    if (!TextUtils.isEmpty(paramBaseFilmData.slots.director)) {
      paramSlots1.director = paramBaseFilmData.slots.director;
    }
    if (!TextUtils.isEmpty(paramBaseFilmData.slots.time)) {
      paramSlots1.time = paramBaseFilmData.slots.time;
    }
    if (!TextUtils.isEmpty(paramBaseFilmData.slots.sequenceId)) {
      paramSlots1.sequenceId = paramBaseFilmData.slots.sequenceId;
    }
    if (!TextUtils.isEmpty(paramBaseFilmData.slots.ticketCount)) {
      paramSlots1.ticketCount = paramBaseFilmData.slots.ticketCount;
    }
    if (!TextUtils.isEmpty(paramBaseFilmData.slots.price)) {
      paramSlots1.price = paramBaseFilmData.slots.price;
    }
    if (!TextUtils.isEmpty(paramBaseFilmData.slots.bookSeat)) {
      paramSlots1.bookSeat = paramBaseFilmData.slots.bookSeat;
    }
    if (!TextUtils.isEmpty(paramBaseFilmData.slots.seatInfo)) {
      paramSlots1.seatInfo = paramBaseFilmData.slots.seatInfo;
    }
    if (!TextUtils.isEmpty(paramBaseFilmData.slots.orderId)) {
      paramSlots1.orderId = paramBaseFilmData.slots.orderId;
    }
    if (!TextUtils.isEmpty(paramBaseFilmData.slots.startTime)) {
      paramSlots1.startTime = paramBaseFilmData.slots.startTime;
    }
    if (!TextUtils.isEmpty(paramBaseFilmData.slots.endTime)) {
      paramSlots1.endTime = paramBaseFilmData.slots.endTime;
    }
    if (!TextUtils.isEmpty(paramBaseFilmData.slots.theaterName)) {
      paramSlots1.theaterName = paramBaseFilmData.slots.theaterName;
    }
    if (!TextUtils.isEmpty(paramBaseFilmData.slots.time)) {
      paramSlots1.time = paramBaseFilmData.slots.time;
    }
    if (!TextUtils.isEmpty(paramBaseFilmData.slots.latitude)) {
      paramSlots1.latitude = paramBaseFilmData.slots.latitude;
    }
    if (!TextUtils.isEmpty(paramBaseFilmData.slots.longitude)) {
      paramSlots1.longitude = paramBaseFilmData.slots.longitude;
    }
    if ((!TextUtils.isEmpty(paramBaseFilmData.slots.ticketCnt)) && (Integer.valueOf(paramBaseFilmData.slots.ticketCnt).intValue() <= 4)) {
      paramSlots1.ticketCnt = paramBaseFilmData.slots.ticketCnt;
    }
    if (paramSlots2 != null)
    {
      if (!TextUtils.isEmpty(paramSlots2.askType)) {
        paramSlots1.askType = paramSlots2.askType;
      }
      if (!TextUtils.isEmpty(paramSlots2.timeInfo)) {
        paramSlots1.timeInfo = paramSlots2.timeInfo;
      }
      if (!TextUtils.isEmpty(paramSlots2.filmInfo)) {
        paramSlots1.filmInfo = paramSlots2.filmInfo;
      }
      if (!TextUtils.isEmpty(paramSlots2.filmId)) {
        paramSlots1.filmId = paramSlots2.filmId;
      }
      if (!TextUtils.isEmpty(paramSlots2.filmName)) {
        paramSlots1.filmName = paramSlots2.filmName;
      }
      if (!TextUtils.isEmpty(paramSlots2.cinema)) {
        paramSlots1.cinema = paramSlots2.cinema;
      }
      if (!TextUtils.isEmpty(paramSlots2.cinemaId)) {
        paramSlots1.cinemaId = paramSlots2.cinemaId;
      }
      if (!TextUtils.isEmpty(paramSlots2.length)) {
        paramSlots1.length = paramSlots2.length;
      }
      if (!TextUtils.isEmpty(paramSlots2.actor)) {
        paramSlots1.actor = paramSlots2.actor;
      }
      if (!TextUtils.isEmpty(paramSlots2.director)) {
        paramSlots1.director = paramSlots2.director;
      }
      if (!TextUtils.isEmpty(paramSlots2.time)) {
        paramSlots1.time = paramSlots2.time;
      }
      if (!TextUtils.isEmpty(paramSlots2.sequenceId)) {
        paramSlots1.sequenceId = paramSlots2.sequenceId;
      }
      if (!TextUtils.isEmpty(paramSlots2.ticketCount)) {
        paramSlots1.ticketCount = paramSlots2.ticketCount;
      }
      if (!TextUtils.isEmpty(paramSlots2.price)) {
        paramSlots1.price = paramSlots2.price;
      }
      if (!TextUtils.isEmpty(paramSlots2.bookSeat)) {
        paramSlots1.bookSeat = paramSlots2.bookSeat;
      }
      if (!TextUtils.isEmpty(paramSlots2.seatInfo)) {
        paramSlots1.seatInfo = paramSlots2.seatInfo;
      }
      if (!TextUtils.isEmpty(paramSlots2.orderId)) {
        paramSlots1.orderId = paramSlots2.orderId;
      }
      if (!TextUtils.isEmpty(paramSlots2.startTime)) {
        paramSlots1.startTime = paramSlots2.startTime;
      }
      if (!TextUtils.isEmpty(paramSlots2.endTime)) {
        paramSlots1.endTime = paramSlots2.endTime;
      }
      if (!TextUtils.isEmpty(paramSlots2.theaterName)) {
        paramSlots1.theaterName = paramSlots2.theaterName;
      }
      if (!TextUtils.isEmpty(paramSlots2.time)) {
        paramSlots1.time = paramSlots2.time;
      }
      if (!TextUtils.isEmpty(paramSlots2.latitude)) {
        paramSlots1.latitude = paramSlots2.latitude;
      }
      if (!TextUtils.isEmpty(paramSlots2.longitude)) {
        paramSlots1.longitude = paramSlots2.longitude;
      }
    }
    return paramSlots1;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/che/codriver/protocol/data/nlp/Slots.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */