import java.util.*;
import java.io.*;

class Graph_decision{
	public static void main(String[] args) {
		ArrayList<Integer> array = new ArrayList<Integer>();//要素数可変配列の確保
		boolean result;//結果格納用変数

		input(array);//入力処理

		System.out.println("処理開始");

		result = havel_hakimi(array);//havel-hakimiによる判断処理

		output(result);//結果出力処理

	}

	//入力処理
	public static void input(ArrayList<Integer> array){
		System.out.println("call input");
		System.out.println("何回入力しますか?");
		Scanner scanner0 = new Scanner(System.in);
		int num = scanner0.nextInt();//要素数格納用
		int cnt = 0;
		//配列に要素を格納
		for (int i=1;i<=num;i++){
			System.out.println(i+"つ目数値を入力して下さい");
			Scanner scanner1 = new Scanner(System.in);
			array.add(scanner1.nextInt());
			System.out.println("入力された数値:"+array.get(i-1));
		}

		System.out.print("入力された配列:");
		while(cnt < num){
			System.out.print(array.get(cnt));
			cnt++;
		}

		System.out.println("\n入力完了\n");
	}

	//内部処理
	public static boolean havel_hakimi(ArrayList<Integer> array){
		boolean temp = false;

		System.out.println("call havel_hakimi");

		for(;array.get(0) > 1;){
			temp = proces(array);
			if(temp == false){
				return temp;
			}
		}
		return judge(array);
	}

	public static boolean proces(ArrayList<Integer> array){
		int cnt = 0;

		System.out.println("\ncall proces");

		int s = array.get(0);
		System.out.println("s = "+s);

		//
		for (int j=0; j<array.size()-1; ++j) {
			System.out.print(array.get(j));
			array.set(j,array.get(j+1));
			System.out.println("→"+array.get(j));
		}

		//数列の最初が数列のサイズより大きかった場合処理終了
		try{
			for(int k=0; k<s; k++){
				array.set(k,array.get(k)-1);
				System.out.print(array.get(k));
			}
		}catch(IndexOutOfBoundsException e){
			System.out.println("\n処理終了");
			return false;
		}
		//配列のラストを消す
		array.remove(array.size()-1);

		System.out.print("\n1を引かれた配列:");
		while(cnt < array.size()){
			System.out.print(array.get(cnt));
			cnt++;
		}

		Collections.sort(array);			//昇順ソートだよ！
		Collections.reverse(array);			//昇順を逆転させて降順にするよ！

		System.out.print("\nソートされた配列:");
		cnt = 0;
		while(cnt < array.size()){
			System.out.print(array.get(cnt));
			cnt++;
		}

		if (array.get(array.size()-1) < 0) {
			return false;
		}

		return true;

	}

	//グラフ的かどうかを最終的に判断
	public static boolean judge(ArrayList<Integer> array){
		int count = 0;

		System.out.println("\ncall judge");

		for (int k = 0; k < array.size(); k++){
			if (array.get(k)== 1){
				count++;
			}
		}
		if ( count%2 == 0 ) {
			return true;
		}else{
			return false;
		}
	}

	//出力処理
	public static void output(boolean result){
		if (result==true) {
			System.out.println("\n\nグラフ的です。\n\n");
		}else{
			System.out.println("\n\nグラフ的ではありません。\n\n");
		}
	}
}