package org.apache.hadoop.hive.ql.cube.processors;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hive.conf.HiveConf;
import org.apache.hadoop.hive.ql.cube.parse.CubeTestSetup;
import org.apache.hadoop.hive.ql.parse.SemanticException;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestCubeDriver {

  private final Configuration conf = new Configuration();
  private CubeDriver driver;

  @BeforeClass
  public static void setup() throws Exception {
    CubeTestSetup setup = new CubeTestSetup();
    setup.createSources();
  }

  public static String HOUR_FMT = "yyyy-MM-dd HH";
  public static final SimpleDateFormat HOUR_PARSER = new SimpleDateFormat(HOUR_FMT);

  public static String MONTH_FMT = "yyyy-MM";
  public static final SimpleDateFormat MONTH_PARSER = new SimpleDateFormat(MONTH_FMT);

  public static String getDateUptoHours(Date dt) {
    return HOUR_PARSER.format(dt);
  }

  public static String getDateUptoMonth(Date dt) {
    return MONTH_PARSER.format(dt);
  }

  @Test
  public void testQueryWithNow() throws Exception {
    driver = new CubeDriver(new HiveConf(conf, HiveConf.class));
    Throwable th = null;
    try {
      String hqlQuery = driver.compileCubeQuery("select SUM(msr2) from testCube" +
    		" where time_range_in('NOW - 2DAYS', 'NOW')");
    } catch (SemanticException e) {
      th = e;
      e.printStackTrace();
    }
    Assert.assertNotNull(th);
  }

  @Test
  public void testCubeWhereQuery() throws Exception {
    driver = new CubeDriver(new HiveConf(conf, HiveConf.class));
    Calendar cal = Calendar.getInstance();
    Date now = cal.getTime();
    System.out.println("Test now:" + now);
    cal.add(Calendar.DAY_OF_MONTH, -2);
    Date twodaysBack = cal.getTime();
    System.out.println("Test twodaysBack:" + twodaysBack);
    System.out.println("Test from:" + getDateUptoHours(twodaysBack) + " to:" + getDateUptoHours(now));
    String hqlQuery = driver.compileCubeQuery("select SUM(msr2) from testCube" +
        " where time_range_in('" + getDateUptoHours(twodaysBack)
        + "','" + getDateUptoHours(now) + "')");
    System.out.println("cube hql:" + hqlQuery);
    //Assert.assertEquals(queries[1], cubeql.toHQL());
  }

  @Test
  public void testCubeWhereQueryForMonth() throws Exception {
    driver = new CubeDriver(new HiveConf(new Configuration(), HiveConf.class));
    Calendar cal = Calendar.getInstance();
    Date now = cal.getTime();
    System.out.println("Test now:" + now);
    cal.add(Calendar.MONTH, -2);
    Date twoMonthsBack = cal.getTime();
    System.out.println("Test twoMonthsBack:" + twoMonthsBack);
    System.out.println("Test from:" + getDateUptoHours(twoMonthsBack) + " to:" + getDateUptoHours(now));
    String hqlQuery = driver.compileCubeQuery("select SUM(msr2) from testCube" +
        " where time_range_in('" + getDateUptoHours(twoMonthsBack)
        + "','" + getDateUptoHours(now) + "')");
    System.out.println("cube hql:" + hqlQuery);
    //Assert.assertEquals(queries[1], cubeql.toHQL());

    // TODO this should consider only two month partitions. Month weight needs
    // to be fixed.
   // hqlQuery = driver.compileCubeQuery("select SUM(msr2) from testCube" +
   //     " where time_range_in('" + getDateUptoMonth(twoMonthsBack)
   //     + "','" + getDateUptoMonth(now) + "')");

  }

  @Test
  public void testDimensionQueryWithMultipleStorages() throws Exception {
    driver = new CubeDriver(new HiveConf(conf, HiveConf.class));
    String hqlQuery = driver.compileCubeQuery("select name, stateid from citytable");
    System.out.println("cube hql:" + hqlQuery);

    conf.set(HiveConf.ConfVars.HIVE_DRIVER_SUPPORTED_STORAGES.toString(), "C2");
    driver = new CubeDriver(new HiveConf(conf, HiveConf.class));
    hqlQuery = driver.compileCubeQuery("select name, stateid from citytable");
    System.out.println("cube hql:" + hqlQuery);
    //Assert.assertEquals(queries[1], cubeql.toHQL());

    conf.set(HiveConf.ConfVars.HIVE_DRIVER_SUPPORTED_STORAGES.toString(), "C1");
    driver = new CubeDriver(new HiveConf(conf, HiveConf.class));
    hqlQuery = driver.compileCubeQuery("select name, stateid from citytable");
    System.out.println("cube hql:" + hqlQuery);

    conf.set(HiveConf.ConfVars.HIVE_DRIVER_SUPPORTED_STORAGES.toString(), "");
    driver = new CubeDriver(new HiveConf(conf, HiveConf.class));
    hqlQuery = driver.compileCubeQuery("select name, stateid from citytable");
    System.out.println("cube hql:" + hqlQuery);

  }

  @Test
  public void testLimitQuery() throws Exception {
    driver = new CubeDriver(new HiveConf(new Configuration(), HiveConf.class));
    String hqlQuery = driver.compileCubeQuery("select name, stateid from citytable limit 100");
    System.out.println("cube hql:" + hqlQuery);
    //Assert.assertEquals(queries[1], cubeql.toHQL());
  }

}