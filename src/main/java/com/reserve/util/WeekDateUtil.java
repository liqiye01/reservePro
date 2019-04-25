package com.reserve.util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

public class WeekDateUtil {

	/**
	 * 获得周一到周日的日期list
	 * @return 
	 */
	public static List<String> getWeekDate(){
		ArrayList<String> list = new ArrayList<>();
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH) + 1;
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		int weekday = calendar.get(Calendar.DAY_OF_WEEK)-1;
		String todayDate = year+"-"+month+"-"+day;
		if(weekday==1){
			calendar.add(Calendar.DATE, 1);
			int year1 = calendar.get(Calendar.YEAR);
			int month1 = calendar.get(Calendar.MONTH) + 1;
			int day1 = calendar.get(Calendar.DAY_OF_MONTH);
			String TueDate=year1+"-"+month1+"-"+day1;
			calendar.add(Calendar.DATE, 1);
			int year2 = calendar.get(Calendar.YEAR);
			int month2 = calendar.get(Calendar.MONTH) + 1;
			int day2 = calendar.get(Calendar.DAY_OF_MONTH);
			String WenDate=year2+"-"+month2+"-"+day2;
			calendar.add(Calendar.DATE, 1);
			int year3 = calendar.get(Calendar.YEAR);
			int month3 = calendar.get(Calendar.MONTH) + 1;
			int day3 = calendar.get(Calendar.DAY_OF_MONTH);
			String ThuDate=year3+"-"+month3+"-"+day3;
			calendar.add(Calendar.DATE, 1);
			int year4 = calendar.get(Calendar.YEAR);
			int month4 = calendar.get(Calendar.MONTH) + 1;
			int day4 = calendar.get(Calendar.DAY_OF_MONTH);
			String FriDate=year4+"-"+month4+"-"+day4;
			calendar.add(Calendar.DATE, 1);
			int year5 = calendar.get(Calendar.YEAR);
			int month5 = calendar.get(Calendar.MONTH) + 1;
			int day5 = calendar.get(Calendar.DAY_OF_MONTH);
			String SatDate=year5+"-"+month5+"-"+day5;
			calendar.add(Calendar.DATE, 1);
			int year6 = calendar.get(Calendar.YEAR);
			int month6 = calendar.get(Calendar.MONTH) + 1;
			int day6 = calendar.get(Calendar.DAY_OF_MONTH);
			String SunDate=year6+"-"+month6+"-"+day6;
			calendar.add(Calendar.DATE, 1);
			int year7 = calendar.get(Calendar.YEAR);
			int month7 = calendar.get(Calendar.MONTH) + 1;
			int day7 = calendar.get(Calendar.DAY_OF_MONTH);
			String MonDate=year7+"-"+month7+"-"+day7;
			list.add(MonDate);
			list.add(TueDate);
			list.add(WenDate);
			list.add(ThuDate);
			list.add(FriDate);
			list.add(SatDate);
			list.add(SunDate);
			list.add(todayDate);
			return list;
		}else if(weekday==2){
			calendar.add(Calendar.DATE, 1);
			int year1 = calendar.get(Calendar.YEAR);
			int month1 = calendar.get(Calendar.MONTH) + 1;
			int day1 = calendar.get(Calendar.DAY_OF_MONTH);
			String WenDate=year1+"-"+month1+"-"+day1;
			calendar.add(Calendar.DATE, 1);
			int year2 = calendar.get(Calendar.YEAR);
			int month2 = calendar.get(Calendar.MONTH) + 1;
			int day2 = calendar.get(Calendar.DAY_OF_MONTH);
			String ThuDate=year2+"-"+month2+"-"+day2;
			calendar.add(Calendar.DATE, 1);
			int year3 = calendar.get(Calendar.YEAR);
			int month3 = calendar.get(Calendar.MONTH) + 1;
			int day3 = calendar.get(Calendar.DAY_OF_MONTH);
			String FriDate=year3+"-"+month3+"-"+day3;
			calendar.add(Calendar.DATE, 1);
			int year4 = calendar.get(Calendar.YEAR);
			int month4 = calendar.get(Calendar.MONTH) + 1;
			int day4 = calendar.get(Calendar.DAY_OF_MONTH);
			String SatDate=year4+"-"+month4+"-"+day4;
			calendar.add(Calendar.DATE, 1);
			int year5 = calendar.get(Calendar.YEAR);
			int month5 = calendar.get(Calendar.MONTH) + 1;
			int day5 = calendar.get(Calendar.DAY_OF_MONTH);
			String SunDate=year5+"-"+month5+"-"+day5;
			calendar.add(Calendar.DATE, 1);
			int year6 = calendar.get(Calendar.YEAR);
			int month6 = calendar.get(Calendar.MONTH) + 1;
			int day6 = calendar.get(Calendar.DAY_OF_MONTH);
			String MonDate=year6+"-"+month6+"-"+day6;
			calendar.add(Calendar.DATE, 1);
			int year7 = calendar.get(Calendar.YEAR);
			int month7 = calendar.get(Calendar.MONTH) + 1;
			int day7 = calendar.get(Calendar.DAY_OF_MONTH);
			String TueDate=year7+"-"+month7+"-"+day7;
			list.add(MonDate);
			list.add(TueDate);
			list.add(WenDate);
			list.add(ThuDate);
			list.add(FriDate);
			list.add(SatDate);
			list.add(SunDate);
			list.add(todayDate);
			return list;
		}else if(weekday==3){
			calendar.add(Calendar.DATE, 1);
			int year1 = calendar.get(Calendar.YEAR);
			int month1 = calendar.get(Calendar.MONTH) + 1;
			int day1 = calendar.get(Calendar.DAY_OF_MONTH);
			String ThuDate=year1+"-"+month1+"-"+day1;
			calendar.add(Calendar.DATE, 1);
			int year2 = calendar.get(Calendar.YEAR);
			int month2 = calendar.get(Calendar.MONTH) + 1;
			int day2 = calendar.get(Calendar.DAY_OF_MONTH);
			String FriDate=year2+"-"+month2+"-"+day2;
			calendar.add(Calendar.DATE, 1);
			int year3 = calendar.get(Calendar.YEAR);
			int month3 = calendar.get(Calendar.MONTH) + 1;
			int day3 = calendar.get(Calendar.DAY_OF_MONTH);
			String SatDate=year3+"-"+month3+"-"+day3;
			calendar.add(Calendar.DATE, 1);
			int year4 = calendar.get(Calendar.YEAR);
			int month4 = calendar.get(Calendar.MONTH) + 1;
			int day4 = calendar.get(Calendar.DAY_OF_MONTH);
			String SunDate=year4+"-"+month4+"-"+day4;
			calendar.add(Calendar.DATE, 1);
			int year5 = calendar.get(Calendar.YEAR);
			int month5 = calendar.get(Calendar.MONTH) + 1;
			int day5 = calendar.get(Calendar.DAY_OF_MONTH);
			String MonDate=year5+"-"+month5+"-"+day5;
			calendar.add(Calendar.DATE, 1);
			int year6 = calendar.get(Calendar.YEAR);
			int month6 = calendar.get(Calendar.MONTH) + 1;
			int day6 = calendar.get(Calendar.DAY_OF_MONTH);
			String TueDate=year6+"-"+month6+"-"+day6;
			calendar.add(Calendar.DATE, 1);
			int year7 = calendar.get(Calendar.YEAR);
			int month7 = calendar.get(Calendar.MONTH) + 1;
			int day7 = calendar.get(Calendar.DAY_OF_MONTH);
			String WenDate=year7+"-"+month7+"-"+day7;
			list.add(MonDate);
			list.add(TueDate);
			list.add(WenDate);
			list.add(ThuDate);
			list.add(FriDate);
			list.add(SatDate);
			list.add(SunDate);
			list.add(todayDate);
			return list;
		}else if(weekday==4){
			calendar.add(Calendar.DATE, 1);
			int year1 = calendar.get(Calendar.YEAR);
			int month1 = calendar.get(Calendar.MONTH) + 1;
			int day1 = calendar.get(Calendar.DAY_OF_MONTH);
			String FriDate=year1+"-"+month1+"-"+day1;
			calendar.add(Calendar.DATE, 1);
			int year2 = calendar.get(Calendar.YEAR);
			int month2 = calendar.get(Calendar.MONTH) + 1;
			int day2 = calendar.get(Calendar.DAY_OF_MONTH);
			String SatDate=year2+"-"+month2+"-"+day2;
			calendar.add(Calendar.DATE, 1);
			int year3 = calendar.get(Calendar.YEAR);
			int month3 = calendar.get(Calendar.MONTH) + 1;
			int day3 = calendar.get(Calendar.DAY_OF_MONTH);
			String SunDate=year3+"-"+month3+"-"+day3;
			calendar.add(Calendar.DATE, 1);
			int year4 = calendar.get(Calendar.YEAR);
			int month4 = calendar.get(Calendar.MONTH) + 1;
			int day4 = calendar.get(Calendar.DAY_OF_MONTH);
			String MonDate=year4+"-"+month4+"-"+day4;
			calendar.add(Calendar.DATE, 1);
			int year5 = calendar.get(Calendar.YEAR);
			int month5 = calendar.get(Calendar.MONTH) + 1;
			int day5 = calendar.get(Calendar.DAY_OF_MONTH);
			String TueDate=year5+"-"+month5+"-"+day5;
			calendar.add(Calendar.DATE, 1);
			int year6 = calendar.get(Calendar.YEAR);
			int month6 = calendar.get(Calendar.MONTH) + 1;
			int day6 = calendar.get(Calendar.DAY_OF_MONTH);
			String WenDate=year6+"-"+month6+"-"+day6;
			calendar.add(Calendar.DATE, 1);
			int year7 = calendar.get(Calendar.YEAR);
			int month7 = calendar.get(Calendar.MONTH) + 1;
			int day7 = calendar.get(Calendar.DAY_OF_MONTH);
			String ThuDate=year7+"-"+month7+"-"+day7;
			list.add(MonDate);
			list.add(TueDate);
			list.add(WenDate);
			list.add(ThuDate);
			list.add(FriDate);
			list.add(SatDate);
			list.add(SunDate);
			list.add(todayDate);
			return list;
		}else if(weekday==5){
			calendar.add(Calendar.DATE, 1);
			int year1 = calendar.get(Calendar.YEAR);
			int month1 = calendar.get(Calendar.MONTH) + 1;
			int day1 = calendar.get(Calendar.DAY_OF_MONTH);
			String SatDate=year1+"-"+month1+"-"+day1;
			calendar.add(Calendar.DATE, 1);
			int year2 = calendar.get(Calendar.YEAR);
			int month2 = calendar.get(Calendar.MONTH) + 1;
			int day2 = calendar.get(Calendar.DAY_OF_MONTH);
			String SunDate=year2+"-"+month2+"-"+day2;
			calendar.add(Calendar.DATE, 1);
			int year3 = calendar.get(Calendar.YEAR);
			int month3 = calendar.get(Calendar.MONTH) + 1;
			int day3 = calendar.get(Calendar.DAY_OF_MONTH);
			String MonDate=year3+"-"+month3+"-"+day3;
			calendar.add(Calendar.DATE, 1);
			int year4 = calendar.get(Calendar.YEAR);
			int month4 = calendar.get(Calendar.MONTH) + 1;
			int day4 = calendar.get(Calendar.DAY_OF_MONTH);
			String TueDate=year4+"-"+month4+"-"+day4;
			calendar.add(Calendar.DATE, 1);
			int year5 = calendar.get(Calendar.YEAR);
			int month5 = calendar.get(Calendar.MONTH) + 1;
			int day5 = calendar.get(Calendar.DAY_OF_MONTH);
			String WenDate=year5+"-"+month5+"-"+day5;
			calendar.add(Calendar.DATE, 1);
			int year6 = calendar.get(Calendar.YEAR);
			int month6 = calendar.get(Calendar.MONTH) + 1;
			int day6 = calendar.get(Calendar.DAY_OF_MONTH);
			String ThuDate=year6+"-"+month6+"-"+day6;
			calendar.add(Calendar.DATE, 1);
			int year7 = calendar.get(Calendar.YEAR);
			int month7 = calendar.get(Calendar.MONTH) + 1;
			int day7 = calendar.get(Calendar.DAY_OF_MONTH);
			String FriDate=year7+"-"+month7+"-"+day7;
			list.add(MonDate);
			list.add(TueDate);
			list.add(WenDate);
			list.add(ThuDate);
			list.add(FriDate);
			list.add(SatDate);
			list.add(SunDate);
			list.add(todayDate);
			return list;
		}else if(weekday==6){
			calendar.add(Calendar.DATE, 1);
			int year1 = calendar.get(Calendar.YEAR);
			int month1 = calendar.get(Calendar.MONTH) + 1;
			int day1 = calendar.get(Calendar.DAY_OF_MONTH);
			String SunDate=year1+"-"+month1+"-"+day1;
			calendar.add(Calendar.DATE, 1);
			int year2 = calendar.get(Calendar.YEAR);
			int month2 = calendar.get(Calendar.MONTH) + 1;
			int day2 = calendar.get(Calendar.DAY_OF_MONTH);
			String MonDate=year2+"-"+month2+"-"+day2;
			calendar.add(Calendar.DATE, 1);
			int year3 = calendar.get(Calendar.YEAR);
			int month3 = calendar.get(Calendar.MONTH) + 1;
			int day3 = calendar.get(Calendar.DAY_OF_MONTH);
			String TueDate=year3+"-"+month3+"-"+day3;
			calendar.add(Calendar.DATE, 1);
			int year4 = calendar.get(Calendar.YEAR);
			int month4 = calendar.get(Calendar.MONTH) + 1;
			int day4 = calendar.get(Calendar.DAY_OF_MONTH);
			String WenDate=year4+"-"+month4+"-"+day4;
			calendar.add(Calendar.DATE, 1);
			int year5 = calendar.get(Calendar.YEAR);
			int month5 = calendar.get(Calendar.MONTH) + 1;
			int day5 = calendar.get(Calendar.DAY_OF_MONTH);
			String ThuDate=year5+"-"+month5+"-"+day5;
			calendar.add(Calendar.DATE, 1);
			int year6 = calendar.get(Calendar.YEAR);
			int month6 = calendar.get(Calendar.MONTH) + 1;
			int day6 = calendar.get(Calendar.DAY_OF_MONTH);
			String FriDate=year6+"-"+month6+"-"+day6;
			calendar.add(Calendar.DATE, 1);
			int year7 = calendar.get(Calendar.YEAR);
			int month7 = calendar.get(Calendar.MONTH) + 1;
			int day7 = calendar.get(Calendar.DAY_OF_MONTH);
			String SatDate=year7+"-"+month7+"-"+day7;
			list.add(MonDate);
			list.add(TueDate);
			list.add(WenDate);
			list.add(ThuDate);
			list.add(FriDate);
			list.add(SatDate);
			list.add(SunDate);
			list.add(todayDate);
			return list;
		}else if(weekday==0){
			calendar.add(Calendar.DATE, 1);
			int year1 = calendar.get(Calendar.YEAR);
			int month1 = calendar.get(Calendar.MONTH) + 1;
			int day1 = calendar.get(Calendar.DAY_OF_MONTH);
			String MonDate=year1+"-"+month1+"-"+day1;
			calendar.add(Calendar.DATE, 1);
			int year2 = calendar.get(Calendar.YEAR);
			int month2 = calendar.get(Calendar.MONTH) + 1;
			int day2 = calendar.get(Calendar.DAY_OF_MONTH);
			String TueDate=year2+"-"+month2+"-"+day2;
			calendar.add(Calendar.DATE, 1);
			int year3 = calendar.get(Calendar.YEAR);
			int month3 = calendar.get(Calendar.MONTH) + 1;
			int day3 = calendar.get(Calendar.DAY_OF_MONTH);
			String WenDate=year3+"-"+month3+"-"+day3;
			calendar.add(Calendar.DATE, 1);
			int year4 = calendar.get(Calendar.YEAR);
			int month4 = calendar.get(Calendar.MONTH) + 1;
			int day4 = calendar.get(Calendar.DAY_OF_MONTH);
			String ThuDate=year4+"-"+month4+"-"+day4;
			calendar.add(Calendar.DATE, 1);
			int year5 = calendar.get(Calendar.YEAR);
			int month5 = calendar.get(Calendar.MONTH) + 1;
			int day5 = calendar.get(Calendar.DAY_OF_MONTH);
			String FriDate=year5+"-"+month5+"-"+day5;
			calendar.add(Calendar.DATE, 1);
			int year6 = calendar.get(Calendar.YEAR);
			int month6 = calendar.get(Calendar.MONTH) + 1;
			int day6 = calendar.get(Calendar.DAY_OF_MONTH);
			String SatDate=year6+"-"+month6+"-"+day6;
			calendar.add(Calendar.DATE, 1);
			int year7 = calendar.get(Calendar.YEAR);
			int month7 = calendar.get(Calendar.MONTH) + 1;
			int day7 = calendar.get(Calendar.DAY_OF_MONTH);
			String SunDate=year7+"-"+month7+"-"+day7;
			list.add(MonDate);
			list.add(TueDate);
			list.add(WenDate);
			list.add(ThuDate);
			list.add(FriDate);
			list.add(SatDate);
			list.add(SunDate);
			list.add(todayDate);
			return list;
		}
		return null;
	}
	
	/**
	 * 
	 * @param reserveTime   在页面选中的预定时间段
	 * @param weekDate   未来一周的日期
	 * @return  
	 */
	public static HashMap<String, String> getBeginAndEndTime(String reserveTime,HashMap<String, String> weekDate){
		HashMap<String, String> beginAndEndTime = new HashMap<String, String>();
		String beginTime="";
		String endTime="";
		if(reserveTime.equals("monMorning")){
			String MonDate = weekDate.get("MonDate");
			beginTime=MonDate+" 08:00:00";
			endTime=MonDate+" 12:00:00";
		}else if(reserveTime.equals("monAfternoon")){
			String MonDate = weekDate.get("MonDate");
			beginTime=MonDate+" 12:00:00";
			endTime=MonDate+" 18:00:00";
		}else if(reserveTime.equals("monEvening")){
			String MonDate = weekDate.get("MonDate");
			beginTime=MonDate+" 18:00:00";
			endTime=MonDate+" 22:00:00";
		}else if(reserveTime.equals("tueMorning")){
			String TueDate = weekDate.get("TueDate");
			beginTime=TueDate+" 08:00:00";
			endTime=TueDate+" 12:00:00";
		}else if(reserveTime.equals("tueAfternoon")){
			String TueDate = weekDate.get("TueDate");
			beginTime=TueDate+" 12:00:00";
			endTime=TueDate+" 18:00:00";
		}else if(reserveTime.equals("tueEvening")){
			String TueDate = weekDate.get("TueDate");
			beginTime=TueDate+" 18:00:00";
			endTime=TueDate+" 22:00:00";
		}else if(reserveTime.equals("wedMorning")){
			String WenDate = weekDate.get("WenDate");
			beginTime=WenDate+" 08:00:00";
			endTime=WenDate+" 12:00:00";
		}else if(reserveTime.equals("wedAfternoon")){
			String WenDate = weekDate.get("WenDate");
			beginTime=WenDate+" 12:00:00";
			endTime=WenDate+" 18:00:00";
		}else if(reserveTime.equals("wedEvening")){
			String WenDate = weekDate.get("WenDate");
			beginTime=WenDate+" 18:00:00";
			endTime=WenDate+" 22:00:00";
		}else if(reserveTime.equals("thuMorning")){
			String ThuDate = weekDate.get("ThuDate");
			beginTime=ThuDate+" 08:00:00";
			endTime=ThuDate+" 12:00:00";
		}else if(reserveTime.equals("thuAfternoon")){
			String ThuDate = weekDate.get("ThuDate");
			beginTime=ThuDate+" 12:00:00";
			endTime=ThuDate+" 18:00:00";
		}else if(reserveTime.equals("thuEvening")){
			String ThuDate = weekDate.get("ThuDate");
			beginTime=ThuDate+" 18:00:00";
			endTime=ThuDate+" 22:00:00";
		}else if(reserveTime.equals("friMorning")){
			String FriDate = weekDate.get("FriDate");
			beginTime=FriDate+" 08:00:00";
			endTime=FriDate+" 12:00:00";
		}else if(reserveTime.equals("friAfternoon")){
			String FriDate = weekDate.get("FriDate");
			beginTime=FriDate+" 12:00:00";
			endTime=FriDate+" 18:00:00";
		}else if(reserveTime.equals("friEvening")){
			String FriDate = weekDate.get("FriDate");
			beginTime=FriDate+" 18:00:00";
			endTime=FriDate+" 22:00:00";
		}else if(reserveTime.equals("satMorning")){
			String SatDate = weekDate.get("SatDate");
			beginTime=SatDate+" 08:00:00";
			endTime=SatDate+" 12:00:00";
		}else if(reserveTime.equals("satAfternoon")){
			String SatDate = weekDate.get("SatDate");
			beginTime=SatDate+" 12:00:00";
			endTime=SatDate+" 18:00:00";
		}else if(reserveTime.equals("satEvening")){
			String SatDate = weekDate.get("SatDate");
			beginTime=SatDate+" 18:00:00";
			endTime=SatDate+" 22:00:00";
		}else if(reserveTime.equals("sunMorning")){
			String SunDate = weekDate.get("SunDate");
			beginTime=SunDate+" 08:00:00";
			endTime=SunDate+" 12:00:00";
		}else if(reserveTime.equals("sunAfternoon")){
			String SunDate = weekDate.get("SunDate");
			beginTime=SunDate+" 12:00:00";
			endTime=SunDate+" 18:00:00";
		}else if(reserveTime.equals("sunEvening")){
			String SunDate = weekDate.get("SunDate");
			beginTime=SunDate+" 18:00:00";
			endTime=SunDate+" 22:00:00";
		}
		beginAndEndTime.put("beginTime", beginTime);
		beginAndEndTime.put("endTime", endTime);
		return beginAndEndTime;
	}
	
	public static String getChineseDate(String date){
		if(date.equals("monMorning")){
			return "星期一早上";
		}else if(date.equals("monAfternoon")){
			return "星期一下午";
		}else if(date.equals("monEvening")){
			return "星期一晚上";
		}else if(date.equals("tueMorning")){
			return "星期二早上";
		}else if(date.equals("tueAfternoon")){
			return "星期二下午";
		}else if(date.equals("tueEvening")){
			return "星期二晚上";
		}else if(date.equals("wedMorning")){
			return "星期三早上";
		}else if(date.equals("wedAfternoon")){
			return "星期三下午";
		}else if(date.equals("wedEvening")){
			return "星期三晚上";
		}else if(date.equals("thuMorning")){
			return "星期四早上";
		}else if(date.equals("thuAfternoon")){
			return "星期四下午";
		}else if(date.equals("thuEvening")){
			return "星期四晚上";
		}else if(date.equals("friMorning")){
			return "星期五早上";
		}else if(date.equals("friAfternoon")){
			return "星期五下午";
		}else if(date.equals("friEvening")){
			return "星期五晚上";
		}else if(date.equals("satMorning")){
			return "星期六早上";
		}else if(date.equals("satAfternoon")){
			return "星期六下午";
		}else if(date.equals("satEvening")){
			return "星期六晚上";
		}else if(date.equals("sunMorning")){
			return "星期天早上";
		}else if(date.equals("sunAfternoon")){
			return "星期天下午";
		}else if(date.equals("sunEvening")){
			return "星期天晚上";
		}else{
			return "";
		}
	}
	
	
}
