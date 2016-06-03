import java.util.*;
import java.io.*;

class Graph_decision{
	public static void main(String[] args) {
		ArrayList<Integer> array = new ArrayList<Integer>();//�v�f���ϔz��̊m��
		boolean result;//���ʊi�[�p�ϐ�

		input(array);//���͏���

		System.out.println("�����J�n");

		result = havel_hakimi(array);//havel-hakimi�ɂ�锻�f����

		output(result);//���ʏo�͏���

	}

	//���͏���
	public static void input(ArrayList<Integer> array){
		System.out.println("call input");
		System.out.println("������͂��܂���?");
		Scanner scanner0 = new Scanner(System.in);
		int num = scanner0.nextInt();//�v�f���i�[�p
		int cnt = 0;
		//�z��ɗv�f���i�[
		for (int i=1;i<=num;i++){
			System.out.println(i+"�ڐ��l����͂��ĉ�����");
			Scanner scanner1 = new Scanner(System.in);
			array.add(scanner1.nextInt());
			System.out.println("���͂��ꂽ���l:"+array.get(i-1));
		}

		System.out.print("���͂��ꂽ�z��:");
		while(cnt < num){
			System.out.print(array.get(cnt));
			cnt++;
		}

		System.out.println("\n���͊���\n");
	}

	//��������
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
			System.out.println("��"+array.get(j));
		}

		//����̍ŏ�������̃T�C�Y���傫�������ꍇ�����I��
		try{
			for(int k=0; k<s; k++){
				array.set(k,array.get(k)-1);
				System.out.print(array.get(k));
			}
		}catch(IndexOutOfBoundsException e){
			System.out.println("\n�����I��");
			return false;
		}
		//�z��̃��X�g������
		array.remove(array.size()-1);

		System.out.print("\n1�������ꂽ�z��:");
		while(cnt < array.size()){
			System.out.print(array.get(cnt));
			cnt++;
		}

		Collections.sort(array);			//�����\�[�g����I
		Collections.reverse(array);			//�������t�]�����č~���ɂ����I

		System.out.print("\n�\�[�g���ꂽ�z��:");
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

	//�O���t�I���ǂ������ŏI�I�ɔ��f
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

	//�o�͏���
	public static void output(boolean result){
		if (result==true) {
			System.out.println("\n\n�O���t�I�ł��B\n\n");
		}else{
			System.out.println("\n\n�O���t�I�ł͂���܂���B\n\n");
		}
	}
}