package stringWeights;
import java.util.ArrayList;
import java.util.List;


public class WeightedStrings {

	private final int stringWeight;
	List<String> myStrings = new ArrayList<String>();

	/**
	 * Create a WeightedStrings object that will hold Strings of the specified
	 * "weight"
	 * 
	 * @param weight
	 *            0 <= weight < 1013
	 * @throws IllegalArgumentException
	 *             if the argument violates requirements.
	 */
	public WeightedStrings(int weight) throws IllegalArgumentException {
		// TODO: implement this method
		if((weight <0) || (weight >= 1013))
			throw new IllegalArgumentException("Weight is either less than 0 or greater than or equal to 1013");
		stringWeight = weight;

	}

	/**
	 * Create a WeightedStrings object using the given array of Strings. All
	 * Strings should be of the same weight and the array should not be empty
	 * otherwise an IllegalArgumentException should be thrown.
	 * 
	 * @param strArray
	 *            strArray.length > 0 and all Strings in this array should have
	 *            the same "weight"
	 * @throws IllegalArgumentException
	 *             if the input arguments do not satisfy the requirements
	 */
	public WeightedStrings(String[] strArray) throws IllegalArgumentException {
		// TODO: implement this method
		if(strArray.length == 0)
			throw new IllegalArgumentException("The string array has length 0");

		int lengthOfArray = strArray.length;
		int strArrayWeight = getStringWeight(strArray[0]);
		stringWeight = strArrayWeight;

		for(int count = 0; count < lengthOfArray; count++) {
			if(getStringWeight(strArray[count]) != strArrayWeight)
					throw new IllegalArgumentException("Element " + count + "has a different weight compared to other strings in this array");
			myStrings.add(strArray[count]);
		}

/*		if(myStrings.size() == 0) {
			stringWeight = 0;
		} else {
			stringWeight = getStringWeight(myStrings.get(0));
		}
*/
	}

	/**
	 * Compute the "weight" of a given String. The weight is computed as the sum
	 * over i in [0, str.length()-1] of (i+1)*(weight of character at position
	 * i) modulo 1013 for all characters that are alphabets and other characters
	 * are ignored. The weight of a character is its ASCII value: weight(A) =
	 * 65, weight(B) = 66, ..., weight(Z) = 90, and weight(a) = 97, ...,
	 * weight(z) = 122.
	 * 
	 * @param str
	 *            is not null
	 * @return weight of the given string
	 */
	public static int getStringWeight(String str) {

		// TODO: implement this method
		int weight = 0;

		for(int count = 0; count < (str.length()); count++) {
			Character currentChar = str.charAt(count);
			int asciiValue = (int) currentChar;

			if(((65 <= asciiValue) && (asciiValue <= 90)) || ((97 <= asciiValue) && (asciiValue <= 122))) {
				weight = (weight + (count + 1)*asciiValue) % 1013;
			}
		}
		return weight;
	}

	/**
	 * Add a new String to the WeightedStrings object. The new string should
	 * have the same weight as other strings in this collection. Adding the same
	 * String multiple times makes no difference when compared with adding that
	 * String once.
	 * 
	 * @param str
	 *            to add to WeightedStrings. It should not be null and its
	 *            weight should match the weight of other Strings in this
	 *            object.
	 * @returns true if str was added to this object (matches weight) and false
	 *          otherwise.
	 */
	public boolean add(String str) {
		// TODO: Implement this method
		boolean exists = false;
		for(int count = 0; count < myStrings.size(); count++) {
			if(str.contentEquals(myStrings.get(count)))
				exists = true;
		}

		if(exists)
			return false;
		else if(getStringWeight(str) != stringWeight)
			return false;
		else if(str == null)
			return false;
		else
			myStrings.add(str);

		return true;
	}

	/**
	 * Compare two WeightedString objects. Two WeightedString objects are equal
	 * if they contain the same Strings. Note, as with the add() method, that adding the same string multiple times has no impact on equality relative to adding the string once. 
	 * 
	 */
	@Override
	public boolean equals(Object other) {
		// TODO: Implement this method
		if(other instanceof  WeightedStrings) {
			if(this.myStrings.size() != ( ((WeightedStrings) other).myStrings.size())) { //i.e. if they've got different number of strings in them
				return false;
			}
			else {
				//Check to see if each and every word in one list appears in the other
				boolean matched = false;
				for(int count = 0; count < this.myStrings.size(); count++) {
					matched = false;
					for (int insideCount = 0; insideCount < this.myStrings.size(); insideCount++) {
						if(this.myStrings.get(count).contentEquals(((WeightedStrings)other).myStrings.get(insideCount) )) {
							matched = true;
							break;
						}
					}
					if(!matched)
						break;
				}
				return matched;
			}
		}
		else return false;
	}

	@Override
	public int hashCode() {
		// TODO: Implement this method
		// Follow the usual rules for hashCode
		int hashCode = 0;
		for(int count = 0; count < myStrings.size(); count++) {
			hashCode += myStrings.get(count).hashCode();
		}
		return hashCode;
	}

	/**
	 * Verify if two WeightedStrings are equivalent. Two WeightedStrings are
	 * equivalent if they are intended to contain Strings of the same weight
	 * even if the actual strings they contain are different. One of the
	 * WeightedStrings may not even contain any strings; only its weight may be
	 * set but that is sufficient to perform the equivalence test.
	 * 
	 * @param other
	 * @return true if the other WeightedString is equivalent to this.
	 */
	public boolean equivalent(WeightedStrings other) {
		// TODO: Implement this method

		return (this.stringWeight == other.stringWeight);
	}

}
