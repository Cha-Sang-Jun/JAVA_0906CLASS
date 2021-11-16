package day0915;
// 배열의 동적 할당(Dynamic Allocation)  
// 우리가 기존의 배열은 크기를 지정하여 해당 크기만 사용을 하였다.
// 예시: 크기가 4인 int 배열 -> int[] arr = new int[4]

import util.ArrayUtil;

// 크기가 고정되어있는 정적 할당 배열의 경우,
// 만약 우리가 지정된 크기보다 많은 값을 넣고 싶어도 넣을 수 없다.
// 또한, 기본형 데이터타입 배열일 경우 0으로, 참조형 데이터타입 배열일 경우 null 로 초기화가 되지만
// 우리가 몇개의 값을 배열에 저장했는지 알아내기 위해서는 추가적으로 작업을 하여서
// 특이한 값으로 초기화 된 배열에 칸이 몇칸인지 알아야 한다.


// 이러한 문제점을 해결하기 위해서 나온 개념이 바로 동적할당이다.
// 동적 할당 배열의 경우, 배열의 크기가 새로운 요소를 추가하면 늘어나고
// 요소를 제거하면 줄어드는 자유로운 크기를 가지게 된다.

// 단, 동적 할당의 경우, 기존 배열을 주소값을 유지한채로 바꾸는게 아니라
// 새로운 배열을 만들어서 변경을 가한 후 해당 배열을 리턴 시켜서
// 기존 배열에 덮어 씌우는 방법을 사용하게 된다.

public class Ex07DynamicAlloc {
	public static void main(String[] args) {
		int[] arr = new int[3];
		arr[0] = 1;
		arr[1] = 3;
		arr[2] = 1;
		// 1. size()
		System.out.println("1. size()");
		System.out.println("ArrayUtil.size(arr): " + ArrayUtil.size(arr));
		System.out.println();
		
		// 2. isEmpty()
		System.out.println("2. isEmpty()");
		System.out.println("ArrayUtil.isEmpty(arr): " + ArrayUtil.isEmpty(arr));
		System.out.println();
		
		// 3. contains()
		System.out.println("3. contains()");
		System.out.println("ArrayUtil.contains(arr,3): " + ArrayUtil.contains(arr, 3));
		System.out.println("ArrayUtil.contains(arr,50): " + ArrayUtil.contains(arr, 50));
		System.out.println();
		
		// 4. indexOf()
		System.out.println("4. indexOf()");
		System.out.println("ArrayUtil.indexOf(arr,1): " + ArrayUtil.indexOf(arr, 1));
		System.out.println("ArrayUtil.indexOf(arr,50): " + ArrayUtil.indexOf(arr, 50));
		System.out.println();
		
		// 5. lastIndexOf()
		System.out.println("5. lastIndexOf()");
		System.out.println("ArrayUtil.lastIndexOf(arr,1): " + ArrayUtil.lastIndexOf(arr, 1));
		System.out.println("ArrayUtil.lastIndexOf(arr,50): " + ArrayUtil.lastIndexOf(arr, 50));
		System.out.println();
		
		// 6. get()
		System.out.println("6. get()");
		System.out.println("ArrayUtil.get(arr,1): " + ArrayUtil.get(arr, 1));
		System.out.println();
		
		// 7. add()
		System.out.println("7. add()");
		System.out.println("add() 전 ArrayUtil.size(arr): " + ArrayUtil.size(arr));
		arr = ArrayUtil.add(arr, 30);
		System.out.println("add() 후 ArrayUtil.size(arr): " + ArrayUtil.size(arr));
		System.out.println("add() 후 ArrayUtil.get(arr,3): " + ArrayUtil.get(arr, 3));
		System.out.println();
		
		// 8. add(index)
		System.out.println("8. add(index)");
		System.out.println("add(index) 전 ArrayUtil.size(arr): " + ArrayUtil.size(arr));
		System.out.println("add(index) 전 ArrayUtil.get(arr,2): " + ArrayUtil.get(arr,2));
		arr = ArrayUtil.add(arr, 2, 10);
		System.out.println("add(index) 후 ArrayUtil.size(arr): " + ArrayUtil.size(arr));
		System.out.println("add(index) 후 ArrayUtil.get(arr,2): " + ArrayUtil.get(arr,2));
		System.out.println();
		
		// 9. set()
		System.out.println("9. set()");
		System.out.println("set(index) 전 ArrayUtil.get(arr,2): " + ArrayUtil.get(arr,2));
		int temp = ArrayUtil.set(arr, 2, 300);
		System.out.println("set(index) 후 ArrayUtil.get(arr,2): " + ArrayUtil.get(arr,2));
		System.out.println("set() 후 원래 2번 인덱스에 있던 값: " + temp);
		System.out.println();
		
		// 10. removeByIndex()
		System.out.println("10. removeByIndex()");
		System.out.println("removeByIndex() 전 ArrayUtil.size(arr): " + ArrayUtil.size(arr));
		System.out.println("removeByIndex() 전 ArrayUtil.indexOf(arr, 300): " + ArrayUtil.indexOf(arr, 300));
		System.out.println("--------유효 인덱스인 경우-----------");
		arr = ArrayUtil.removeByIndex(arr, 2);
		System.out.println("removeByIndex() 후 ArrayUtil.size(arr): " + ArrayUtil.size(arr));
		System.out.println("removeByIndex() 후 ArrayUtil.indexOf(arr, 300): " + ArrayUtil.indexOf(arr, 300));
		System.out.println("----------유효 인덱스가 아닌 경우------------");
		System.out.println("removeByIndex() 전 ArrayUtil.size(arr): " + ArrayUtil.size(arr));
		arr = ArrayUtil.removeByIndex(arr,  3000);
		System.out.println("removeByIndex() 후 ArrayUtil.size(arr): " + ArrayUtil.size(arr));
		
		
		// 11. removeByElement()
		System.out.println("11. removeByElement()");
		System.out.println("removeByElement() 전 ArrayUtil.indexOf(arr, 3): " + ArrayUtil.indexOf(arr, 3));
		arr = ArrayUtil.removeByElemnet(arr, 3);
		System.out.println("removeByElement() 후 ArrayUtil.indexOf(arr, 3): " + ArrayUtil.indexOf(arr, 3));
		
		System.out.println();
	}

}
