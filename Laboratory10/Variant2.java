/*
* 2)	https://www.kaggle.com/dwdkills/russian-demography
*
* */

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import static org.apache.spark.sql.functions.*;

// 1 Подсчитать общее количество записей в наборе данных:
SparkSession spark = SparkSession.builder().appName("Russian Demography").getOrCreate();

Dataset<Row> russianDemography = spark.read().option("header", "true").csv("./russian_demography.csv");

long count = russianDemography.count();

System.out.println("Total number of records: " + count);

//2 Подсчитать количество записей для каждого региона:
Dataset<Row> regionCounts = russianDemography.groupBy("region").agg(count("*").alias("count"));

regionCounts.show();
// 3 Найти наиболее часто встречающийся год рождения:
Dataset<Row> mostCommonBirthYear = russianDemography.groupBy("birth_year")
.agg(count("*").alias("count"))
.orderBy(desc("count"))
.limit(1);

mostCommonBirthYear.show();
// 4 Найти количество мужчин и женщин в каждом регионе:
Dataset<Row> genderCountsByRegion = russianDemography.groupBy("region", "gender")
.agg(count("*").alias("count"))
.orderBy("region", "gender");

genderCountsByRegion.show();
// 5 Найти самый популярный месяц рождения:
Dataset<Row> mostCommonBirthMonth = russianDemography.groupBy("birth_month")
.agg(count("*").alias("count"))
.orderBy(desc("count"))
.limit(1);

mostCommonBirthMonth.show();
// 6 Найти средний возраст для каждого региона:
Dataset<Row> averageAgeByRegion = russianDemography.groupBy("region")
.agg(avg("age").alias("average_age"))
.orderBy("region");

averageAgeByRegion.show();

//  7 Найти количество родившихся мужчин и женщин по годам:
Dataset<Row> genderCountsByYear = russianDemography.groupBy("birth_year", "gender")
.agg(count("*").alias("count"))
.orderBy("birth_year", "gender");

genderCountsByYear.show();
// 8 Найти наиболее часто встречающуюся фамилию:
Dataset<Row> mostCommonSurname = russianDemography.groupBy("surname")
.agg(count("*").alias("count"))
.orderBy(desc("count"))
.limit(1);

mostCommonSurname.show();
// 9 Найти количество родившихся в каждом месяце для каждого года:
Dataset<Row> birthMonthCountsByYear = russianDemography.groupBy("birth_year", "birth_month")
.agg(count("*").alias("count"))
.orderBy("birth_year", "birth_month");

birthMonthCountsByYear.show();

// 10 Найти количество родившихся в каждом регионе по годам:
Dataset<Row> birthYearCountsByRegion = russianDemography.groupBy("region", "birth_year")
.agg(count("*").alias("count"))
.orderBy("region", "birth_year");

birthYearCountsByRegion.show();
