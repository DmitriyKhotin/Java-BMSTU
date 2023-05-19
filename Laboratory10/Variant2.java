import org.apache.spark.sql.{SparkSession, functions}
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types.DoubleType
import org.apache.spark.sql.types.IntegerType

val spark = SparkSession.builder().appName("Russian Demography").getOrCreate()

val russianDemography = spark.read.option("header", "true").csv("./russian_demography.csv")

// 1 Подсчитать общее количество записей в наборе данных:
val count = russianDemography.count()
println("Total number of records: " + count)

// 2 Подсчитать количество записей для каждого региона:
val regionCounts = russianDemography.groupBy("region").agg(functions.count("*").alias("count"))
regionCounts.show()

// 3 Найти наибольшее и наименьшее значение столбца "npg":
val dfWithNPG = russianDemography.withColumn("npg", col("npg").cast(DoubleType))

val minNPG = dfWithNPG.agg(min("npg")).as[Double].first()
val maxNPG = dfWithNPG.agg(max("npg")).as[Double].first()
println("Minimum NPG: " + minNPG)
println("Maximum NPG: " + maxNPG)

// 4 Рассчитать среднее значение столбца "birth_rate" по регионам:
val averageBirthRateByRegion = russianDemography.groupBy("region").agg(avg("birth_rate").alias("average_birth_rate"))
averageBirthRateByRegion.show()

// 5 Найти регион с наибольшим и наименьшим значением столбца "death_rate":
val maxDeathRateRegion = russianDemography.orderBy(desc("death_rate")).select("region").first().getString(0)
val minDeathRateRegion = russianDemography.orderBy(asc("death_rate")).select("region").first().getString(0)
println("Region with maximum death rate: " + maxDeathRateRegion)
println("Region with minimum death rate: " + minDeathRateRegion)

// 6 Рассчитать суммарное значение столбца "gdw" для каждого года:
val gdwSumByYear = russianDemography.groupBy("year").agg(sum("gdw").alias("total_gdw"))
gdwSumByYear.show()

// 7 Найти год с наибольшим и наименьшим значением столбца "urbanization":
val dfWithYear = russianDemography.withColumn("year", col("year").cast(IntegerType))

val maxUrbanizationYear = dfWithYear.orderBy(desc("urbanization")).select("year").first().getInt(0)
println("Year with maximum urbanization: " + maxUrbanizationYear)

val minUrbanizationYear = dfWithYear.orderBy(asc("urbanization")).select("year").first().getInt(0)
println("Year with minimum urbanization: " + minUrbanizationYear)

// 8 Рассчитать среднее значение столбца "npg" для каждого года:
val averageNPGByYear = russianDemography.groupBy("year").agg(avg("npg").alias("average_npg"))
averageNPGByYear.show()

// 9 Найти регион с наибольшим и наименьшим значением столбца "birth_rate":
val maxBirthRateRegion = russianDemography.orderBy(desc("birth_rate")).select("region").first().getString(0)
val minBirthRateRegion = russianDemography.orderBy(asc("birth_rate")).select("region").first().getString(0)
println("Region with maximum birth rate: " + maxBirthRateRegion)
println("Region with minimum birth rate: " + minBirthRateRegion)

// 10 Рассчитать среднее значение столбца "death_rate" для каждого года:
val averageDeathRateByYear = russianDemography.groupBy("year").agg(avg("death_rate").alias("average_death_rate"))
averageDeathRateByYear.show()

