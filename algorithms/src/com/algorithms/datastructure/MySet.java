package com.algorithms.datastructure;

public class MySet {
    private final int tableSize = 4;
    private Entry[] table = new Entry[tableSize];

    private int size;

    private class Entry {
	Integer data;
	MyList link;

	private Entry(Integer data, MyList link) {
	    this.data = data;
	    this.link = link;
	}

    }

    public boolean add(Integer data) {
	if (data == null) {
	    throw new NullPointerException(data + " can't be null");
	}

	int index = hash(data);
	if (size == 0) {
	    Entry entry = new Entry(data, null);
	    table[index] = entry;
	    size++;
	    return true;
	}

	Entry e = get(index);
	if (e == null) {
	    // no value found at index, add it to table
	    Entry entry = new Entry(data, null);
	    table[index] = entry;
	    size++;
	} else {
	    // if value already present at table, simply return false to
	    // maintain Set uniqueness
	    if (e.data.equals(data)) {
		return false;
	    } else {
		// if index at collision, form linked list and add data to list
		if (e.link == null) {
		    MyList link = new MyList();
		    link.add(e.data);
		    link.add(data);
		    table[index].link = link;
		    size++;
		} else {
		    if (!e.link.contains(data)) {
			table[index].link.add(data);
			size++;
		    } else {
			return false;
		    }
		}
	    }
	}
	return true;
    }

    private Entry get(int index) {
	return table[index];
    }

    private int hash(Integer data) {
	final int prime = 31;
	int result = prime * data.hashCode();
	int hash = result % tableSize;
	return hash;
    }

    public int size() {
	return size;
    }

    public String toString() {
	if (size == 0)
	    return "[]";
	StringBuilder builder = new StringBuilder();
	builder.append("[");
	int count = 0;
	for (Entry e : table) {
	    if (e != null) {
		MyList link = e.link;
		if (link == null) {
		    count++;
		    builder.append(e.data);

		} else {
		    count += e.link.size();
		    builder.append(e.link);
		}
		if (count != size) {
		    builder.append(", ");
		}
	    }
	}
	builder.append("]");
	return builder.toString();
    }
}
