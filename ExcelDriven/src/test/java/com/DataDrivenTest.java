package com;

import java.io.IOException;
import java.util.ArrayList;

public class DataDrivenTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		dataDriven data = new dataDriven();
		ArrayList list = data.getData("Add Profile");
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
		ArrayList list2 = data.getAllData();
		for(int i=0;i<list2.size();i++) {
			System.out.println(list2.get(i));
		}

	}

}
