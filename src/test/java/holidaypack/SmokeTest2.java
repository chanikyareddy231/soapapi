package holidaypack;

import java.util.Scanner;

import holidaypack.EnricoStub.DateType;
import holidaypack.EnricoStub.LocalizedStringType;
import holidaypack.EnricoStub.WhereIsPublicHoliday;
import holidaypack.EnricoStub.WhereIsPublicHolidayCountryListType;
import holidaypack.EnricoStub.WhereIsPublicHolidayResponse;
import holidaypack.EnricoStub.WhereIsPublicHolidayType;

public class SmokeTest2 {

	public static void main(String[] args) throws Exception
	{
		//Take data from keyboard
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a day");
		int d=sc.nextInt();
		System.out.println("Enter a month");
		int m=sc.nextInt();
		System.out.println("Enter a year");
		int y=sc.nextInt();
		//
		EnricoStub stub=new EnricoStub();
		DateType dt=new DateType();
		dt.setDay(d);
		dt.setMonth(m);
		dt.setYear(y);
		WhereIsPublicHoliday req=new WhereIsPublicHoliday();
		req.setDate(dt);
		WhereIsPublicHolidayResponse res=stub.whereIsPublicHoliday(req);
		WhereIsPublicHolidayCountryListType lt=res.getCountryList();
		try
		{
			WhereIsPublicHolidayType[] cs=lt.getCountry();
			for(WhereIsPublicHolidayType c:cs)	
			{
				System.out.println(c.getCountryCode()+"--"+c.getCountryFullName());
				LocalizedStringType[] ls=c.getHolidayName();
				for(LocalizedStringType l:ls)
				{
					System.out.println(l.getLang()+"--"+l.getText());
				}
			}
				
		}
		catch(Exception ex)
		{
			System.out.println("No holiday for given date in all supported countries");
		}

	}

}
