import java.util.*;

class Main {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		String[] S = scan.next().split("");
		scan.close();

		int cnt = 0;

		String[] cer = new String[S.length];

		Arrays.fill(cer, "");

		for (String s : S) {
			if (s.equals("+") || s.equals("-")) {
				cnt++;
				cer[cnt] += s;
				cnt++;
			} else {
				cer[cnt] += s;
			}
		}

		int[] nums = new int[50];
		String[] oper = new String[50];
		int oper_cnt = 0;
		cnt = 0;
		for (String s : cer) {
			if (s.equals("+") || s.equals("-")) {
				oper[oper_cnt] = s;
				oper_cnt++;
			} else if(s.equals("")){
				break;
			}else{
				nums[cnt] = Integer.parseInt(s);
				cnt++;
			}
		}

		int len = cnt;
		int sum = nums[0];
		int temp = 0;
		boolean sub = false;
		int op = 0;
		for (int i = 1; i < len; i++) {
			// 55-50+40
			if(i+1==len){
				if (oper[op].equals("+")) {
					if (sub) {
						temp += nums[i];
					} else {
						sum += nums[i];
					}
					sum-=temp;
				} else {
					if (sub) {
						sum -= temp;
						sub = true;
						temp = 0;
						temp+=nums[i];
					} else {
						sub = true;
						temp += nums[i];
					}

					sum-=temp;

				}
				break;		
			}
			if (oper[op].equals("+")) {
				if (sub) {
					temp += nums[i];
				} else {
					sum += nums[i];
				}
			} else {
				if (sub) {
					sum -= temp;
					sub = true;
					temp = 0;
					temp+=nums[i];
				} else {
					sub = true;
					temp += nums[i];
					
				}
			}

			op++;
		}

		System.out.println(sum);

	}
}