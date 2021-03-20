package holidaypack;

import holidaypack.EnricoStub.DateType;
import holidaypack.EnricoStub.GetSupportedCountries;
import holidaypack.EnricoStub.GetSupportedCountriesResponse;
import holidaypack.EnricoStub.SupportedCountriesType;
import holidaypack.EnricoStub.SupportedCountryType;

public class SmokeTest1 
{
	public static void main(String[] args) throws Exception 
	{
		//No inputs for "GetSupportedcountries" operation
		//Create request object for desired operation in service
		EnricoStub stub=new EnricoStub();
		//create request object for desired operation in service
		GetSupportedCountries req=new GetSupportedCountries();
		//create response object by submitting request to service
		GetSupportedCountriesResponse res=stub.getSupportedCountries(req);
		//Parse response for required values
		SupportedCountriesType sct=res.getSupportedCountries();
		SupportedCountryType[] x=sct.getSupportedCountry();
		System.out.println("Count of all countries is "+x.length);
		for(SupportedCountryType ct:x)
		{
			//get full name and country code
			System.out.println(ct.getFullName()+"----"+ct.getCountryCode());
			//get from-date
			DateType fd=ct.getFromDate();
			System.out.println(fd.getDay()+"-"+fd.getMonth()+"-"+fd.getYear());
			//get to-date
			DateType td=ct.getToDate();
			System.out.println(td.getDay()+"-"+td.getMonth()+"-"+td.getYear());
			//get regions if exists
			try
			{
			String[] rgs=ct.getRegion();
				for (String rs:rgs)
				{	
					System.out.print(rs+ "\t");
				}
				System.out.println();
			}
			catch(Exception ex)
			{
				System.out.println("No Region to "+ct.getRegion());
			}
			//get holidayType if exists
			try 
			{
				String[] hdt=ct.getHolidayType();
				for (String ht:hdt)
				{	
					System.out.print(ht+ "\t");
				}
				System.out.println();
			}
			catch(Exception ex)
			{
				System.out.println("No Region to "+ct.getRegion());
			}

		}
			
		
	}

}
