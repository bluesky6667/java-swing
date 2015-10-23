package lotto;

import java.util.Arrays;

public class Lotto {
	int[] lotto = new int[6];
	public Lotto() {
		this.setLotto();
	}
	public int[] getLotto() {
		return lotto;
	}

	public void setLotto() {
		for (int i = 0; i < lotto.length; i++) {
			int temp = vote();
			if (i == 0) {
				lotto[i] = temp;
			} else {
				for (int j = 0; j < i; j++) {
					if (lotto[j]==temp) {
						i--;
						break;
					}
					lotto[i] = temp;
				}
			}
		}
		Arrays.sort(lotto);
	}
	
	/*public void setLotto() {
		for (int i = 0; i < lotto.length; i++) {
			int temp = vote();
			if (i == 0) {
				lotto[i] = temp;
			} else {
				for (int j = 0; j < i; j++) {
					while (isDupl(j, temp)) {
						temp = vote();
						j = 0;
					}
				}
				lotto[i] = temp;
			}
		}
		Arrays.sort(lotto);
	}*/

	public String printLotto() {
		System.out.println("********부자되세요********");

		for (int i = 0; i < lotto.length; i++) {
			System.out.print(lotto[i] + "\t");
		}
		String s = "";
		return s;
	}

	private int vote(){
		return (int) (Math.random()*45+1);	// 랜덤숫자 발생. 1부터 45까지
	}
	
	/**
	 * 앞에서 추출된 숫자가 뒤에서 다시 추출되는 것을 막기위해서 숫자 중복여부를 체크해야함
	 * count => money/1000 개념으로 돈에 따른 로또 횟수
	 */
	private boolean isDupl(int count, int randomNum){
			if (randomNum==lotto[count]) {		// lottos[1][i] == randomNum
				return true;
			}
		return false;
	}
}
