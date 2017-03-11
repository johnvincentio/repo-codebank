/**
 * Source: SampleDataProvider.java
 * Version: ${VERSION}$
 * Copyright © ${2003-2004}$ by ActiveTree Inc.
 * All rights reserved.
 *
 * Warning:
 * This source code provided to help you understand how the smart jprint APIs
 * can work for your program. It carries no liability for any kind of damage
 * non-functioning and any other as specified in the license terms and consitions
 * for any product.
 *
 * This example program is redistributable provided it carries the above
 * copy right and warning information.
 */
package demo.activetree.print.saveas;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class SampleDataProvider {
  public JTable getJTable() {
    String[] cols =
            {"EmpNo", "Employee Name", "SSN", "Date Of Birth",
             "Home Phone", "Work Phone", "Street Address",
             "Apt/House No", "City", "State", "Zip Code"};
    String[][] data = new String[100][cols.length];

    //Create same data for the table.
    int empNo = 1000;
    String name = "Employee Name - ";
    String ssn = "SSN - ";
    String dob = "Date - ";
    String homePhone = "Home Phone - ";
    String workPhone = "Work Phone - 000";
    String stAddr = "Street Address - ";
    String houseNo = "Apt/House No # ";
    String city = "City Name - ";
    String state = "State Name - ";
    String zipcode = "Zip Code - ";
    for (int row=0; row < data.length; row++) {
      data[row][0] = String.valueOf(empNo+row);
      data[row][1] = name + row;
      data[row][2] = ssn + row;
      data[row][3] = dob + row;
      data[row][4] = homePhone + row;
      data[row][5] = workPhone + row;
      data[row][6] = stAddr + row;
      data[row][7] = houseNo + row;
      data[row][8] = city + row;
      data[row][9] = state + row;
      data[row][10] = zipcode + row;

      if (row == 2) {
        data[row][1] = null;
        data[row][2] = null;
        data[row][3] = null;
      }
    }

    DefaultTableModel tableModel = new DefaultTableModel(data, cols) {
      public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
      }
    };
    JTable table = new JTable(tableModel);
    return table;
  }
}