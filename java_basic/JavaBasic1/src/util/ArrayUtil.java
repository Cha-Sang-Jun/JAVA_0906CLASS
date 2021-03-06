package util;

import struct.Student;

// 배열의 동적 할당 및 배열에 유용한 메소드를
// 구현한 ArrayUtil 클래스
public class ArrayUtil {
	// 1. int[]
	// 1-A. 현재 배열의 크기를 return 하는 sizeOf()
	public static int size(int[] arr) {
		return arr.length;

	}

	// 1-B. 현재 배열이 비어있는지 확인하는 isEmpty()
	public static boolean isEmpty(int[] arr) {
		return size(arr) == 0;
	}

	// 1-C. 현재 배열에서 파라미터로 들어온 int 값이 존재하는지 확인하는 contains()
	public static boolean contains(int[] arr, int e) {
		for (int i = 0; i < size(arr); i++) {
			if (arr[i] == e) {
				return true;
			}
		}

		return false;
	}

	// 1-D. 현재 배열에서 파라미터로 들어온 int 값이 몇번째 인덱스에 있는지
	// 찾아서 리턴하는 indexOf()
	// 만약 해당 int 값이 배열 안에 없으면,
	// 가장 간단하게 불가능한 인덱스를 표시할 수 있는
	// -1이 리턴된다.
	// 만약 해당 int 값이 배열에 여러번 저장되어있을 경우
	// 가장 먼저 등장하는 인덱스가 리턴된다.
	public static int indexOf(int[] arr, int e) {
		for (int i = 0; i < size(arr); i++) {
			if (arr[i] == e) {
				return i;
			}
		}

		return -1;
	}

	// 1-E. 현재 배열에서 파라미터로 들어온 int 값의 가장 마지막 인덱스를
	// 리턴하는 lastIndexOf().
	// 만약 해당 int 값이 배열 안에 없으면 -1이 리턴된다.
	public static int lastIndexOf(int[] arr, int e) {
		for (int i = size(arr) - 1; i >= 0; i--) {
			if (arr[i] == e) {
				return i;
			}
		}

		return -1;
	}

	// 1-F. 현재 배열에서 파라미터로 들어온 인덱스에 있는 값을 리턴하는 get().
	public static int get(int[] arr, int index) {
		return arr[index];
	}

	// 1-G. 현재 배열에 가장 맨 끝에 파라미터로 들어온 값을 추가하는 add()
	public static int[] add(int[] arr, int e) {
//		// 1. arr의 내용을 int[] temp에 복사한다.
//		int[] temp = new int[size(arr)];
//		for(int i = 0; i < size(arr); i++) {
//			temp[i] = get(arr, i);
//		}	
//		// 2. arr을 크기가 1 늘어난 배열로 초기화한다.
//		arr = new int[size(temp) + 1];
//		// 3. temp의 내용을 arr에 복사한다.
//		for(int i = 0; i < size(temp); i++) {
//			arr[i] = get(temp, i);
//		}
//		// 4. arr의 가장 마지막 인덱스를 e로 초기화 한다.
//		arr[size(arr) - 1] = e; 
//      return arr;

		// 1. arr보다 크기가 1 늘어난 int[] temp를 만든다.
		int[] temp = new int[size(arr) + 1];

		// 2. arr의 내용을 temp에 복사한다.
		for (int i = 0; i < size(arr); i++) {
			temp[i] = get(arr, i);
		}

		// 3. temp의 가장 마지막 인덱스에 e를 저장한다.
		temp[size(arr)] = e;

		// 4. 새로운 요소가 추가된 temp를 리턴한다
		return temp;

	}

	// 1-H. 현재 배열에 특정 인덱스에 파라미터로 들어온 값을 추가하는 add().
	public static int[] add(int[] arr, int index, int e) {
//			// 1. arr의 현재 내용을 임시 배열 temp에 옮겨 닮는다.
//			int[] temp = new int[size(arr)];
//			for(int i = 0; i < size(arr); i++) {
//				temp[i] = get(arr, i);
//			}
//			// 2. arr의 크기를 1 늘린다.
//			arr = new int[size(temp) +1];
//			// 3. 0부터 'index -1' 까지의 temp의 내용을 arr에 옮긴다.
//			for(int i = 0; i < index; i++) {
//				arr[i] = get(temp, i);
//			}
//			// 4. arr의 index번 칸에 e를 저장한다.
//			arr[index] = e;	
//			// 5. temp의 index번 칸부터 끝까지를 arr에 담되
//			//    arr의 경우, 인덱스를 변경해야 정상적으로 저장이 된다.
//			for(int i = index; i < size(temp); i++) {
//				arr[i+1] = get(temp,i);
//			}
//			return arr; -> hard

		// 1. int[] temp를 만든다.
		int[] temp = new int[0];

		// 2. 0~index - 1 까지의 arr의 내용을 temp에 추가한다.
		for (int i = 0; i < index; i++) {
			temp = add(temp, get(arr, i));
		}

		// 3. e를 추가한다.
		temp = add(temp, e);

		// 4. index부터 끝까지의 arr의 내용을 temp에 추가한다.
		for (int i = index; i < size(arr); i++) {
			temp = add(temp, get(arr, i));
		}

		// 5. 작업이 완료된 temp를 리턴한다.
		return arr; // -> easy
	}

	// 1-I. 현재 배열에 특정 인덱스의 값을 파라미터로 들어온 값으로 교체하고
	// 원래 있던 값을 리턴해주는 set().
	public static int set(int[] arr, int index, int e) {
		int temp = get(arr, index);

		arr[index] = e;

		return temp;
	}

	// 1-J. 현재 배열에 특정 인덱스의 값을 삭제하는 removeByIndex().
	public static int[] removeByIndex(int[] arr, int index) {
		// 1. 만약 사용자가 잘못된 index를 넣었을 경우
		// 원본인 arr을 그대로 리턴한다.
		if (!(index >= 0 && index < size(arr))) {
			return arr;
		}

//			// 2. int[] temp를 만들어서 arr의 현재 내용을 복사한다. (Hard모드)
//			int[] temp = new int[size(arr)];
//			for(int i = 0; i < size(arr); i++) {
//				temp[i] = get(arr, i);
//			}
//			
//			// 3. arr의 크기를 1 줄인다.
//			arr = new int[size(temp) - 1];
//			
//			// 4. 0부터 index-1 까지의 temp의 값을 arr에 저장한다.
//			for(int i = 0; i < index; i++) {
//				arr[i] = get(temp, i);
//			}
//			
//			// 5. index+1 부터 끝까지의 temp의 값을 arr에 저장한다.
//			for(int i = index+1; i < size(temp); i++) {
//				arr[i - 1] = get(temp, i);
//			}
//			
//			// 6. arr을 리턴한다.
//			return arr;

		// Easy 모드
		// 1. 변경된 내용을 담을 int[] temp
		int[] temp = new int[0];

		// 2. for문을 사용하여 i가 인덱스가 아닌 경우
		// temp에 arr의 i번 내용을 추가한다.
		for (int i = 0; i < size(arr); i++) {
			if (i != index) {
				temp = add(temp, get(arr, i));
			}
		}

		// 3. temp를 리턴한다.
		return temp;
	}

	// 1-K. 현재 배열에서 파라미터로 들어온 int 값을 찾아서 삭제하는
	// removeByElement()
	public static int[] removeByElemnet(int[] arr, int e) {
//			int index = indexOf(arr, e);
//			arr = removeByIndex(arr, index);
//			return arr; 
		return removeByIndex(arr, indexOf(arr, e));
	}

	// 1-L. 현재 배열을 오름차순 정렬하는 sort()
	public static void sort(int[] arr) {
		for (int i = 0; i < size(arr) - 1; i++) {
			if (get(arr, i) > get(arr, i + 1)) {
//					int temp = get(arr, i);
//					arr[i] = get(arr, i+1);
//					arr[i+1] = temp; -> 이 3줄을 한줄로 줄일 수 있음.
				arr[i + 1] = set(arr, i, get(arr, i + 1));
				i = -1;
			}
		}
	}

	
	// 2. String[]
	// 2-A. size()
	public static int size(String[] arr) {
		return arr.length;
	}

	// 2-B. isEmpty()
	public static boolean isEmpty(String[] arr) {
		return size(arr) == 0;
	}

	// 2-C. contains()
	public static boolean contains(String[] arr, String e) {
		for (int i = 0; i < size(arr); i++) {
			if (arr[i].equals(e)) {
				return true;
			}
		}

		return false;
	}

	// 2-D. indexOf()
	public static int indexOf(String[] arr, String e) {
		for (int i = 0; i < size(arr); i++) {
			if (get(arr, i).equals(e)) {
				return i;
			}
		}
		return -1;
	}

	// 2-E. lastIndexOf()
	public static int lastIndexOf(String[] arr, String e) {
		for (int i = size(arr) - 1; i >= 0; i--) {
			if (get(arr, i).equals(e)) {
				return i;
			}
		}

		return -1;
	}

	// 2-F. get()
	public static String get(String[] arr, int index) {
		return arr[index];
	}

	// 2-G. add()
	public static String[] add(String[] arr, String e) {
		String[] temp = new String[size(arr) + 1];

		for (int i = 0; i < size(arr); i++) {
			temp[i] = get(arr, i);
		}

		temp[size(arr)] = e;

		return temp;
	}

	// 2-H. add(index)
	public static String[] add(String[] arr, int index, String e) {
		String[] temp = new String[0];

		for (int i = 0; i < index; i++) {
			temp = add(temp, get(arr, i));
		}

		temp = add(temp, e);

		for (int i = index; i < size(arr); i++) {
			temp = add(temp, get(arr, i));
		}

		return temp;
	}

	// 2-I. set()
	public static String set(String[] arr, int index, String e) {
		String temp = get(arr, index);
		arr[index] = e;

		return temp;
	}

	// 2-J. remove(int index)
	public static String[] remove(String[] arr, int index) {
//			if(index < 0 || index >= size(arr)) {
//				return arr;
//			}  -> 실질적으로 필요하지 않은 코드

		String[] temp = new String[0];

		for (int i = 0; i < size(arr); i++) {
			if (i != index) {
				temp = add(temp, get(arr, i));
			}
		}

		return temp;
	}

	// 2-K. remove(String e) -> 스트링 배열은 remove로 이름 통일 가능.
	public static String[] remove(String[] arr, String e) {
		return remove(arr, indexOf(arr, e));
	}

	
	// 3. Student[]
	// 3-A. size()
	public static int size(Student[] arr) {
		return arr.length;
	}

	// 3-B. isEmpty()
	public static boolean isEmpty(Student[] arr) {
		return size(arr) == 0;
	}

	// 3-C. contains()
	public static boolean contains(Student[] arr, Student s) {
		for (int i = 0; i < arr.length; i++) {
			if (get(arr, i).id == s.id) {
				return true;
			}
		}

		return false;
	}

	// 3-D. indexOf()
	public static int indexOf(Student[] arr, Student s) {
		for (int i = 0; i < size(arr); i++) {
			if (get(arr, i).id == s.id) {
				return i;
			}
		}

		return -1;
	}

	// 3-E. lastIndexOf()
	public static int lastIndexOf(Student[] arr, Student s) {
		for (int i = size(arr) - 1; i >= 0; i--) {
			if (get(arr, i).id == s.id) {
				return i;
			}
		}

		return -1;
	}

	// 3-F. get()
	public static Student get(Student[] arr, int index) {
		return arr[index];
	}

	// 3-G. add()
	public static Student[] add(Student[] arr, Student s) {
		Student[] temp = new Student[size(arr) + 1];

		for (int i = 0; i < size(arr); i++) {
			temp[i] = get(arr, i);
		}

		temp[size(temp) - 1] = s;

		return temp;
	}

	// 3-H. add(index)
	public static Student[] add(Student[] arr, int index, Student s) {
		Student[] temp = new Student[0];

//		for(int i = 0; i < index; i++) {
//			temp = add(temp, get(arr, i));
//		}	
//		temp = add(temp, s);
//		for(int i = 0; i < size(arr); i++) {
//			temp = add(temp, get(arr, i));
//		}

		for (int i = 0; i < size(arr);) {
			if (i != index) {
				temp = add(temp, get(arr, i));
				i++;
			} else {
				temp = add(temp, s);
			}
		}

		return temp;
	}

	// 3-I. set()
	public static Student set(Student[] arr, int index, Student s) {
		Student temp = get(arr, index);
		arr[index] = s;

		return temp;
	}

	// 3-J. remove(index)
	public static Student[] remove(Student[] arr, int index) {
		Student[] temp = new Student[0];

		for (int i = 0; i < size(arr); i++) {
			if (i != index) {
				temp = add(temp, get(arr, i));
			}
		}

		return temp;
	}

	// 3-K. remove()
	public static Student[] remove(Student[] arr, Student s) {
		return remove(arr, indexOf(arr, s));
	}

	
	// 4. classEx.Student[]
	// 4-A. size()
	public static int size(classEx.Student[] arr) {
		return arr.length;
	}

	// 4-B. isEmpty()
	public static boolean isEmpty(classEx.Student[] arr) {
		return size(arr) == 0;
	}

	// 4-C. contains()
	public static boolean contains(classEx.Student[] arr, classEx.Student s) {
		for (int i = 0; i < arr.length; i++) {
			if (get(arr, i).equals(s)) {
				return true;
			}
		}

		return false;
	}

	// 4-D. indexOf()
	public static int indexOf(classEx.Student[] arr, classEx.Student s) {
		for (int i = 0; i < size(arr); i++) {
			if (get(arr, i).equals(s)) {
				return i;
			}
		}

		return -1;
	}

	// 4-E. lastIndexOf()
	public static int lastIndexOf(classEx.Student[] arr, classEx.Student s) {
		for (int i = size(arr) - 1; i >= 0; i--) {
			if (get(arr, i).equals(s)) {
				return i;
			}
		}

		return -1;
	}

	// 4-F. get()
	public static classEx.Student get(classEx.Student[] arr, int index) {
		return arr[index];
	}

	// 4-G. add()
	public static classEx.Student[] add(classEx.Student[] arr, classEx.Student s) {
		classEx.Student[] temp = new classEx.Student[size(arr) + 1];

		for (int i = 0; i < size(arr); i++) {
			temp[i] = get(arr, i);
		}

		temp[size(temp) - 1] = s;

		return temp;
	}

	// 4-H.add(index)
	public static classEx.Student[] add(classEx.Student[] arr, int index, classEx.Student s) {
		classEx.Student[] temp = new classEx.Student[0];

		for (int i = 0; i < size(arr);) {
			if (i != index) {
				temp = add(temp, get(arr, i));
				i++;
			} else {
				temp = add(temp, s);
			}
		}

		return temp;
	}

	// 4-I. set()
	public static classEx.Student set(classEx.Student[] arr, int index, classEx.Student s) {
		classEx.Student temp = get(arr, index);
		arr[index] = s;

		return temp;
	}

	// 4-J. remove(index)
	public static classEx.Student[] remove(classEx.Student[] arr, int index) {
		classEx.Student[] temp = new classEx.Student[0];

		for (int i = 0; i < size(arr); i++) {
			if (i != index) {
				temp = add(temp, get(arr, i));
			}
		}

		return temp;
	}

	// 4-K. remove()
	public static classEx.Student[] remove(classEx.Student[] arr, classEx.Student s) {
		return remove(arr, indexOf(arr, s));
	}
}
