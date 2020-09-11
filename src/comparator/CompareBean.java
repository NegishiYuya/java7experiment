package comparator;

import lombok.Data;

/**
 * 1日前の点数と2日前の点数をまとめるためのBeanクラス.
 *
 */
@Data
public class CompareBean {
  // 1日前の点数
  private long oneDayAgoPoint;
  // 2日前の点数
  private long twoDaysAgoPoint;
  // ランダム
  private long RandomPoint;

  /**
   * 2日前から1日前の点数の増加率を小数第2位で四捨五入し返す.
   *
   * @return float 小数第2位で四捨五入された2日前から1日前の点数の増加率
   */
  public float getRateOfIncrease() {
    // 2日前の点数が0の場合
    if (this.twoDaysAgoPoint == 0) {
      return 0.0f;
    }
    float rateOfIncrease = ((float) this.oneDayAgoPoint / (float) this.twoDaysAgoPoint) - 1.0f;
    // 増加率を小数第2位で四捨五入して返す(一度10倍した値を小数第1位で四捨五入し、10で割る）
    return (float) Math.round(rateOfIncrease * 10) / 10;
  }
}
