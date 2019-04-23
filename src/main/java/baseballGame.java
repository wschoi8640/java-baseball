import java.util.Scanner;

/*
 * ���� �߱� ������ ������ Ŭ����
 * 
 * @version			1.00 2019�� 3�� 24��
 * @author 			Wonseok Choi
 */
public class baseballGame {

	/*
	 * ������ �� 3���� ���� 3�ڸ� ���� ����� �ִ� �޼ҵ�
	 * 
	 * @return 			������ ���ڸ��� 
	 */
	public static int getComNum() {
		int first = (int)(Math.random()*9 + 1);		// 100�� �ڸ���
    	int second = (int)(Math.random()*9 + 1);	// 10�� �ڸ���
    	int third = (int)(Math.random()*9 + 1);		// 1�� �ڸ���
    	
    	/* �ڸ������� �ߺ����� �ʵ��� �Ѵ�*/
    	while((second == first)) {
    		second = (int)(Math.random()*9 + 1);
    	}
    	while((third == first) 
	    	|| (third == second)) {
    		third = (int)(Math.random()*9 + 1);
	    }
    	
    	return (first*100 + second*10 + third);
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
	    
	    int gameMode = 1;							// ���� ���� ����
    	int comNum = getComNum();					// ������ ���ڸ� ��
    	
	    while(gameMode == 1) {
	    	
	    	System.out.print("���ڸ� �Է����ּ��� : ");
		    int myNum = sc.nextInt();				// ������� ���ڸ� ��
		    
		    int [] comNumArr = new int[3];			// comNum�� �� �ڸ��� ����
		    int [] myNumArr = new int[3];			// myNum�� �� �ڸ��� ����
		    int [] tempArr = new int[10];			// ������ ���� �迭
		    
		    int comNumTemp = comNum;				// comNum �ӽ� ����
		    int myNumTemp = myNum;					// myNum �ӽ� ����
		    
		    /* ���ڸ� ���� �ڸ��� ������ �迭�� ���� */
		    for(int i = 0; i < 3; i++) {
		        comNumArr[i] = comNumTemp % 10;
		        myNumArr[i] = myNumTemp % 10;
		        
		        comNumTemp = comNumTemp / 10;
		        myNumTemp = myNumTemp / 10;
		    }
		    
		    /* 
		     * ���� �迭�� comNum ��ġ �� �Է�
		     * 
		     * ��)
		     * comNum = 234 �� ���
		     * tempArr[2] = (0+1)*-1 (2�� ��ġ�� 0��°)
		     * tempArr[3] = (1+1)*-1 (3�� ��ġ�� 1��°)
		     * tempArr[4] = (2+1)*-1 (4�� ��ġ�� 2��°)
		     * 
		     * */
		    for(int i = 0; i < 3; i++) {
		    	int comNumVal = comNumArr[i];
		    	tempArr[comNumVal] = (i+1)*-1;
		    }
		    
		    /* 
		     * myNum ��ġ ���� ���� �迭�� ��
		     * 
		     * ��)
		     * myNum = 432 �� ���
		     * tempArr[2] != (2+1)*-1 (2�� ��ġ�� 2��°) 
		     * tempArr[3] == (1+1)*-1 (3�� ��ġ�� 1��°)
		     * tempArr[4] != (0+1)*-1 (4�� ��ġ�� 0��°) 
		     * 
		     * */
		    for(int i = 0; i < 3; i++) {
		    	int myNumVal = myNumArr[i];
		    	
		    	/* ��Ʈ����ũ�� ��� (��, �ڸ��� ��ġ) */
		    	if((tempArr[myNumVal] != 0) 
		    		&& (tempArr[myNumVal] == (i+1)*-1)) {
		    		tempArr[myNumVal] = 1; 
		    	}
		    	/* ���� ��� (�� ��ġ, �ڸ��� ����ġ) */
		    	else if((tempArr[myNumVal] != 0) 
		    		&& (tempArr[myNumVal] != (i+1)*-1)) {
		    		tempArr[myNumVal] = 2;
		    	}
		    	/* ������ ��� (��, �ڸ��� ����ġ) */
		    	else {
		    		tempArr[myNumVal] = 3;
		    	}
		    }
		    
		    
		    int strike = 0;				// ��Ʈ����ũ ��
		    int ball = 0;				// �� ��
		    
		    /* ��Ʈ����ũ�� ���� ���� ���� */
		    for(int i = 0; i < 10; i++) {
		    	if(tempArr[i] == 1) {
		    		strike++;
		    	}
		    	else if(tempArr[i] == 2) {
		    		ball++;
		    	}
		    }
		    
		    /* ����� ��� */
		    if(strike != 0) {
		    	System.out.print(strike + "��Ʈ����ũ ");
		    }
		    if(ball != 0) {
		    	System.out.print(ball + "��");
		    }
		    System.out.println();
		    
		    /* 3��Ʈ����ũ �� ���Ӹ�� ����*/
		    if(strike == 3) {
		    	System.out.println("3���� ���ڸ� ��� �����̽��ϴ�! ��������");
		    	System.out.println("������ ���� �����Ϸ��� 1, �����Ϸ��� 2�� �Է��ϼ���.");
		    	gameMode = sc.nextInt();
		    	comNum = getComNum();		// ���ο� ������ ���ڸ���
		    }
	    }
	    sc.close();
	}
}
