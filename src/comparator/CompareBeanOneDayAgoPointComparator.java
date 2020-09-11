package comparator;

import java.util.Comparator;

/**
 * CompareBeanのComparatorの実装クラス<br>
 * 1日前の点数を表す変数oneDayAgoPoint で比較する.
 *
 */
public class CompareBeanOneDayAgoPointComparator implements Comparator<CompareBean> {

  @Override
  public int compare(CompareBean o1, CompareBean o2) {
    long o1OneDayAgoPoint = o1.getOneDayAgoPoint();
    long o2OneDayAgoPoint = o2.getOneDayAgoPoint();
    // 1日前の点数を比較する
    int oneDayAgoPointCompareResult = Long.compare(o1OneDayAgoPoint, o2OneDayAgoPoint);
    // 1日前の点数の比較結果が0であれば、ランダムの得点で比較する
    if (oneDayAgoPointCompareResult == 0) {
      return Long.compare(o1.getRandomPoint(), o2.getRandomPoint());
    }
    return oneDayAgoPointCompareResult;
  }

}
