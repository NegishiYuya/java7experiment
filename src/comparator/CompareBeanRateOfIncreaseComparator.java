package comparator;

import java.util.Comparator;

/**
 * CompareBeanのComparatorの実装クラス<br>
 * 2日前から1日前の点数の増加率を表す変数rateOfIncrease で比較する.
 *
 */
public class CompareBeanRateOfIncreaseComparator implements Comparator<CompareBean> {

  @Override
  public int compare(CompareBean o1, CompareBean o2) {
    float o1RateOfIncrease = o1.getRateOfIncrease();
    float o2RateOfIncrease = o2.getRateOfIncrease();
    // 増加率比較する
    int rateOfIncreaseCompareResult = Float.compare(o1RateOfIncrease, o2RateOfIncrease);
    // 増加率の比較結果が0であれば、ランダムの得点で比較する
    if (rateOfIncreaseCompareResult == 0) {
      return Long.compare(o1.getRandomPoint(), o2.getRandomPoint());
    }
    return rateOfIncreaseCompareResult;
  }
}
