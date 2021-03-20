package mypack;

import java.util.Scanner;

import mypack.CalculatorStub.Add;
import mypack.CalculatorStub.AddResponse;
import mypack.CalculatorStub.Divide;
import mypack.CalculatorStub.DivideResponse;
import mypack.CalculatorStub.Multiply;
import mypack.CalculatorStub.MultiplyResponse;
import mypack.CalculatorStub.Subtract;
import mypack.CalculatorStub.SubtractResponse;

public class Smoketest
{
	public static void main(String[] args) throws Exception
	{
		//get data from keyboard
		Scanner sc=new Scanner(System.in);
		System.out.println("input1");
		int x=sc.nextInt();
		System.out.println("input2");
		int y=sc.nextInt();
		sc.close();
		//create object to stub class
		CalculatorStub stub=new CalculatorStub();
		//Add operation testing
		Add req1=new Add();
		req1.setIntA(x);
		req1.setIntB(y);
		AddResponse res1=stub.add(req1);
		int z1=res1.getAddResult();
		System.out.println(z1);
		if(z1==x+y)
		{
			System.out.println("Test passed");
		}
		else
		{
			System.out.println("Test Failed");
		}
		//Subtract operation testing
		Subtract req2=new Subtract();
		req2.setIntA(x);
		req2.setIntB(y);
		SubtractResponse res2=stub.subtract(req2);
		int z2=res2.getSubtractResult();
		System.out.println(z2);
		if(z2==x-y)
		{
			System.out.println("Test passed");
		}
		else
		{
			System.out.println("Test Failed");
		}
		//Multiply operation testing
		Multiply req3=new Multiply();
		req3.setIntA(x);
		req3.setIntB(y);
		MultiplyResponse res3=stub.multiply(req3);
		int z3=res3.getMultiplyResult();
		System.out.println(z3);
		if(z3==x*y)
		{
			System.out.println("Test passed");
		}
		else
		{
			System.out.println("Test Failed");
		}
		//Divide operation testing
		Divide req4=new Divide();
		req4.setIntA(x);
		req4.setIntB(y);
		DivideResponse res4=stub.divide(req4);
		int z4=res4.getDivideResult();
		System.out.println(z4);
		if(z4==x/y)
		{
			System.out.println("Test passed");
		}
		else
		{
			System.out.println("Test Failed");
		}
	}
}
