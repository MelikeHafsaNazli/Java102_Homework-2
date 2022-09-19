package myList;

public class MyList<T> {

	private int index = 0;
	private T[] arr;
	private int capacity = 10;

	MyList() {
		this.arr = (T[]) new Object[capacity];
	}

	MyList(int capacity) {
		this.capacity = capacity;
	}

	int size() {

		return index;
	}

	int getCapacity() {
		return this.capacity;
	}

	void add(T data) {
		if (index == this.capacity) {
			T[] newArray = (T[]) new Object[capacity * 2];
			int i = 0;
			for (T arr : this.arr) {
				newArray[i] = arr;
				i++;
			}
			this.arr = newArray;
			this.capacity = this.capacity * 2;
		}
		arr[index] = data;
		index++;
	}

	T get(int index) {
		if (index < 0 || index > this.index) {
			return null;
		} else {
			return arr[index];
		}
	}

	T remove(int index) {
		this.index--;
		if (index < 0 || index > this.index) {
			return null;
		} else {
			T deleteIndexValue = this.arr[index];
			for (int i = index; i < this.index; i++) {
				this.arr[i] = this.arr[i + 1];
			}
			this.arr[size()] = null;
			return deleteIndexValue;
		}
	}

	public T set(int index, T data) {
		if (index < 0 || index > this.index) {
			return null;
		} else {
			T setIndexValue = this.arr[index];
			this.arr[index] = data;
			return setIndexValue;
		}
	}

	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("[");
		for (T arr : this.arr) {
			if (arr != null) {
				stringBuilder.append(arr.toString() + ",");
			}
		}
		stringBuilder.deleteCharAt(stringBuilder.length() - 1);
		stringBuilder.append("]");
		return stringBuilder.toString();
	}

	public int indexOf(T data) {
		int dataIndex = 0;
		boolean isThere = false;
		for (T arr : this.arr) {
			if (arr == data) {
				isThere = true;
				break;
			}
			dataIndex++;
		}
		return isThere == true ? dataIndex : -1;
	}

	public int lastIndexOf(T data) {
		int dataIndex = 0;
		int lastIndex = 0;
		boolean isThere = false;
		for (T arr : this.arr) {
			if (arr == data) {
				isThere = true;
				lastIndex = dataIndex;
			}
			dataIndex++;
		}
		return isThere == true ? lastIndex : -1;
	}

	boolean isEmpty() {
		return index == 0 ? true : false;
	}

	public T[] toArray() {
		return this.arr;
	}

	public void clear() {
		this.index = 0;
		this.capacity = 10;
		T[] newArray = (T[]) new Object[this.capacity];
		this.arr = newArray;
	}

	MyList<T> subList(int start, int finish) {
		MyList<T> newMyList = new MyList<>();
		for (int i = start + 1; i < finish; i++) {
			newMyList.add(this.arr[i]);
		}
		return newMyList;
	}

	public boolean contains(T data) {
		boolean isThere = false;
		for (T arr : this.arr) {
			if (arr == data) {
				isThere = true;
			}
		}
		return isThere;
	}

}
