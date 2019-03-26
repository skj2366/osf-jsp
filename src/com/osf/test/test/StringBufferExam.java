package com.osf.test.test;

public class StringBufferExam {

//	public static void main(String[] args) {
//		long sTime = System.currentTimeMillis();
//		String str = "";
//		StringBuffer sb = new StringBuffer();
//		for(int i=1;i<=10000;i++) {
//			//str += i+"t";
//			sb.append(i+"t");
//		}
//		str = sb.toString();
//		long eTime = System.currentTimeMillis() - sTime;
//		System.out.println("execute time : " + eTime);
//	}
}
//대량의 데이터를 쌓아야할 때는 문자열(?) 더하기 보다는 스트링 버퍼를 사용하면 훨씬 빠르다 ~


/*
 * {"message":
 * 	{"@type":"response",
 * 	"@service":"naverservice.nmt.proxy",
 * 	"@version":"1.0.0",
 * 	"result":{"srcLangType":"ko",
 * 			"tarLangType":"ja",
 * 			"translatedText":"こんにちは!友達!良い朝だよ!"
 * 			}
 * 	}
 * }
 */		//JSON  MAP 구조 .

/*
 * 1.gson - Google
 * 2.jackson - Spring
 */
