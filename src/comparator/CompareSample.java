package comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class CompareSample {

  /**
   * Comparatorを使ってListを並び替えする.
   *
   * @param args 実行引数
   */
  @SuppressWarnings("unchecked")
  public static void main(String[] args) {

    // 並び替え前のList
    ArrayList<CompareBean> sourceList = makeCompareBeanList(10);
    System.out.println("====== 並び替え前のList START ======");
    for (int i = 0; i < sourceList.size(); i++) {
      printBean(sourceList.get(i), i, true);
    }
    System.out.println("====== 並び替え前のList END ======\n");

    // 1日前得点 降順の並び替え
    ArrayList<CompareBean> sortedBeanList1 = (ArrayList<CompareBean>) sourceList.clone();
    Collections.sort(sortedBeanList1,
        Collections.reverseOrder(new CompareBeanOneDayAgoPointComparator()));
    System.out.println();
    System.out.println("====== 1日前得点 降順で並び替え後のList START ======");
    for (int i = 0; i < sortedBeanList1.size(); i++) {
      printBean(sortedBeanList1.get(i), i, false);
    }
    System.out.println("====== 1日前得点 降順で並び替え後のList END ======\n");

    // 増加率 降順の並び替え
    ArrayList<CompareBean> sortedBeanList2 = (ArrayList<CompareBean>) sourceList.clone();
    Collections.sort(sortedBeanList2,
        Collections.reverseOrder(new CompareBeanRateOfIncreaseComparator()));
    System.out.println();
    System.out.println("====== 増加率 降順で並び替え後のList START ======");
    for (int i = 0; i < sortedBeanList2.size(); i++) {
      printBean(sortedBeanList2.get(i), i, true);
    }
    System.out.println("====== 増加率 降順で並び替え後のList END ======");
  }

  /**
   * CompareBeanのListを作る.
   *
   * @param listSize Listの件数
   * @return ArrayList&lt;CompareBean&gt; CompareBeanのList
   */
  private static ArrayList<CompareBean> makeCompareBeanList(int listSize) {
    ArrayList<CompareBean> compareBeanList = new ArrayList<>(listSize);
    Random r1 = new Random();
    Random r2 = new Random();
    Random r3 = new Random();
    for (int i = 0; i < listSize; i++) {
      CompareBean bean = new CompareBean();
      bean.setOneDayAgoPoint(r1.nextInt(20));
      bean.setTwoDaysAgoPoint(r2.nextInt(20));
      bean.setRandomPoint(r3.nextInt(20));
      compareBeanList.add(bean);
    }
    return compareBeanList;
  }

  private static void printBean(CompareBean bean, int index, boolean isDispRate) {
    StringBuilder sb = new StringBuilder(String.valueOf(index + 1));
    sb.append(" 番目の要素 ");
    sb.append(" 2日前の得点 ");
    sb.append(bean.getTwoDaysAgoPoint());
    sb.append(" 1日前の得点 ");
    sb.append(bean.getOneDayAgoPoint());
    sb.append(" 上昇率 ");
    sb.append(bean.getRateOfIncrease());
    sb.append(" ランダム点 ");
    sb.append(bean.getRandomPoint());
    System.out.println(sb);
  }
}
