package iti.test.maven.titanic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;
import joinery.DataFrame;
import tech.tablesaw.api.DoubleColumn;
import tech.tablesaw.api.NumberColumn;
import tech.tablesaw.api.StringColumn;
import tech.tablesaw.api.Table;

/**
 * Hello world!
 *
 */
public class App {

    String titanicCsvPath = "src//main//java//resources//titanic.csv";
    String hrCsvPath = "src//main//java//resources//HR_comma_sep2.csv";

    public static void main(String[] args) {
        App app = new App();
        System.out.println("=====================Lab 5===============================");
        System.out.println("=====================Using TableSaw======================");
        app.getPassengersDataUsingTableSaw();
        System.out.println("=====================Using Joinary=======================");
        app.getPassengersDataUsingJoinery();
        System.out.println("=====================Join DataFrames=======================");
        app.joinDataFrames();
    }

    public List<TitanicPassnger> getPassengersDataUsingTableSaw() {
        List<TitanicPassnger> allPassengers = new ArrayList<>();
        try {
            Table titanicData = Table.read().csv(titanicCsvPath);
            System.out.println("getDataSummary : " + this.getDataSummary(titanicData));
            System.out.println("getDataInfoStructure : " + this.getDataInfoStructure(titanicData));
            mapTextColumnToNumber(titanicData);
            System.out.println("getDataSummary : " + this.getDataSummary(titanicData));
            System.out.println("getDataInfoStructure : " + this.getDataInfoStructure(titanicData));
            System.out.println("shape : " + titanicData.shape());

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return allPassengers;
    }

    public List<TitanicPassnger> getPassengersDataUsingJoinery() {
        List<TitanicPassnger> allPassengers = new ArrayList<>();
        try {
            DataFrame titanicDataFrame = DataFrame.readCsv(titanicCsvPath);
            System.out.println("getDataSummary : " + titanicDataFrame.describe());
            System.out.println("getDataSummary : " + titanicDataFrame.toString());
            System.out.println("titanicDataFrame Max : " + titanicDataFrame.max());
            System.out.println("titanicDataFrame Min : " + titanicDataFrame.min());
            System.out.println("getDataInfoStructure Mean : " + titanicDataFrame.mean());
            System.out.println("getDataInfoStructure Median : " + titanicDataFrame.median());
            System.out.println("getDataInfoStructure Standard Deviation: " + titanicDataFrame.stddev());
            System.out.println("getDataInfoStructure Variance: " + titanicDataFrame.var());
            TitanicPassnger[] cast =(TitanicPassnger[]) titanicDataFrame.cast(TitanicPassnger.class).toArray();
            System.out.println(cast[0].getName());
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return allPassengers;
    }

    public DataFrame joinDataFrames() {
        DataFrame titanicDataFrame = null;
        DataFrame hrDataFrame = null;
        try {
            titanicDataFrame = DataFrame.readCsv(titanicCsvPath);
            hrDataFrame = DataFrame.readCsv(hrCsvPath);
            titanicDataFrame = titanicDataFrame.join(hrDataFrame);
            System.out.println("getDataSummary : " + titanicDataFrame.describe());
            System.out.println("getDataSummary : " + titanicDataFrame.toString());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return titanicDataFrame;
    }

    //get Data Summary
    public String getDataSummary(Table data) {
        Table summary = data.summary();
        return summary.toString();
    }

    //get the structure of the data
    public String getDataInfoStructure(Table data) {
        Table dataStructure = data.structure();
        return dataStructure.toString();
    }

    // mapping text data to numeric values on the sex field female=1,male=0 and adding a column named gender
    public Table mapTextColumnToNumber(Table data) {
        NumberColumn mappedGenderColumn;
        StringColumn gender = (StringColumn) data.column("sex");
        List<Number> mappedGenderValues = new ArrayList<>();
        for (String v : gender) {
            if ((v != null) && (v.equals("female"))) {
                mappedGenderValues.add(1);
            } else {
                mappedGenderValues.add(0);
            }
        }
        mappedGenderColumn = DoubleColumn.create("gender", mappedGenderValues);
        data.addColumns(mappedGenderColumn);
        return data;
    }
}
