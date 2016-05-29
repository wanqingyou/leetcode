// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {
    private Integer peekedElement;
    private boolean hasPeeked;
    private Iterator<Integer> iterator;
	public PeekingIterator(Iterator<Integer> iterator) {
	    this.iterator=iterator;
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
	    if(!hasPeeked){
            peekedElement=iterator.next();
            hasPeeked=true;
	    }
        return peekedElement;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    if(!hasPeeked){
	        return iterator.next();
	    }
	    int result=peekedElement;
	    peekedElement = null;
	    hasPeeked=false;
	    
	    return result;
	}

	@Override
	public boolean hasNext() {
	    return hasPeeked || iterator.hasNext();
	}
}