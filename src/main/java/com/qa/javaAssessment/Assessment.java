package com.qa.javaAssessment;

import java.util.ArrayList;

public class Assessment {

	// Given a string, return a string where
	// for every char in the original string,
	// there are three chars.

	// multChar("The") ==> "TTThhheee"
	// multChar("AAbb") ==> "AAAAAAbbbbbb"
	// multChar("Hi-There") ==> "HHHiii---TTThhheeerrreee"

	public String multChar(String input) {
		String word = "";
		for (int i = 0; i< input.length(); i++) {
			word += input.substring(i, i+1);
			word += input.substring(i, i+1);
			word += input.substring(i, i+1);
		}
		return word;
	}
	
	// Return the string (backwards) that is between the first and last appearance
	// of "bert"
	// in the given string, or return the empty string "" if there is not 2
	// occurances of "bert" - Ignore Case

	// getBert("bertclivebert") ==> "evilc"
	// getBert("xxbertfridgebertyy") ==> "egdirf"
	// getBert("xxBertfridgebERtyy") ==> "egdirf"
	// getBert("xxbertyy") ==> ""
	// getBert("xxbeRTyy") ==> ""
	
	// DONE
	public String getBert(String input) {

		boolean foundBert1 = false;
		boolean foundBert2 = false;
		
		String letter = "";
		
		String resultLetters = "";
		
		
		for(int i = 0; i < input.length(); i++) {
			
			// single letter of string
			letter = input.substring(i, i+1);
			
			
			
			//if we have found bert1, but haven't enough room for bert2, then break the loop!

			
			//Check for bert each time, if we find him this is true
			if(input.substring(i, i+4).toLowerCase().equals("bert")) { // If we find bert!
				
				
				// If we haven't found bert 1, this newly found bert is bert1
				if(!foundBert1) {
					i += 3; // Skip over the next letters of bert
					foundBert1 = true; // Found the first bert!
					
					// Check whether there is room for bert2! if not, break, if there is continue!
					if(!(i < input.length()-4)) {
						break;
					} else {
						continue; // Nothing else we can do once we found bert 1
					}
					
				}

				// If we have found bert1 and haven't found bert 2 yet, this is bert2
				if(foundBert1) {
					foundBert2 = true;
					// If we find bert2 then we don't need to look further in the string (As values are between bert and bert)
					break; // Break the loop
				}
				
				
			} else if (foundBert1) { // If we found bert1, and we've checked for bert2 this loop and he isnt present, add this letter to the result letters
				
				resultLetters = letter + resultLetters; // This basically reverses the order of found letters
				
			}
		}
		
		// If we found bert1 and bert2, return what was in between them
		if(foundBert1 && foundBert2) {
			return resultLetters;
		} else { // else return nothing
			return "";
		}
	}

	// Given three ints, a b c, one of them is small, one is medium and one is
	// large. Return true if the three values are evenly spaced, so the
	// difference between small and medium is the same as the difference between
	// medium and large. Do not assume the ints will come to you in a reasonable
	// order.

	// evenlySpaced(2, 4, 6) ==> true
	// evenlySpaced(4, 6, 2) ==> true
	// evenlySpaced(4, 6, 3) ==> false
	// evenlySpaced(4, 60, 9) ==> false
	
	//DONE
	public boolean evenlySpaced(int a, int b, int c) {
		
		// Re order the integers by size
		int[] values = {a, b, c};
		int tempValue = 0;
		int intCase = 0;
		int intCase2 = 0;
		
		//values[0] = 77;
		
		//Bubble sort iterate
		for(int i = 0; i < values.length; i++) {
			for(int valI = 0; valI < values.length-1; valI++) {
				
				if(values[valI] > values[valI+1]) {
					
					// Store next value that is smaller
					tempValue = values[valI+1];
					
					// switch around the values
					values[valI+1] = values[valI];
					values[valI] = tempValue;
				}
			}
		}
		//first comparison
		
		
		intCase = values[1] - values[0];
		intCase2 = values[2] - values[1];
		
		
		if(intCase2 == intCase) {
			return true;
		} else {
			return false;
		}
	}


	// Given a string and an int n, return a string that removes n letters from the 'middle' of the string.
	// The string length will be at least n, and be odd when the length of the input is odd.

	// nMid("Hello", 3) ==> "Ho"
	// nMid("Chocolate", 3) ==> "Choate"
	// nMid("Chocolate", 1) ==> "Choclate"
	
	//DONE
	public String nMid(String input, int a) {
		
		ArrayList<Integer> indexToRemove = new ArrayList<Integer>();
		
		String resultingString = "";
		
		//assuming odd
		//find the middle index
		int middleIndex = input.length() / 2;
		int removeEitherSide = a - 1; // The amount of values to remove either side
		if (a > 0) {
			indexToRemove.add(middleIndex);
		}
		
		int backward = 1;
		int forward = 1;
		
		for(int i = 1; i <= removeEitherSide; i++) {
			
			// every other time
			if(i%2 == 0) {
				indexToRemove.add(middleIndex+forward);
				forward++;
			} else {
				indexToRemove.add(middleIndex-backward);
				backward++;
			}
		}
		// for every two take one from either side of the index
		
		// We now have a list of indexes to exclude
		// Construct string skipping these
		for(int x = 0; x < input.length(); x++) {
			String currentVal = input.substring(x, x+1);
			
			//Variable for verifying if this an index to exclude, assumes it isn't
			boolean excluded = false;
			
			//for each index to exclude, check this against the current index
			for(int removes : indexToRemove) {
				if(x == removes) { // If they match, set excluded make this clear and then break this inner loop
					excluded = true;
					break;
				}
			}
			
			if(excluded) { // If excluded is true then we continue past this letter and go onto the next
				continue; 
			} else { // If this isn't one of the excluded indexes, add this to the resultingString!
				resultingString += currentVal;
			}
			
			
		}
		
		return resultingString;
	}


	// Given a string, return the length of the largest "block" in the string.
	// A block is a run of adjacent chars that are the same.
	//
	// superBlock("hoopplla") ==> 2
	// superBlock("abbCCCddDDDeeEEE") ==> 3
	// superBlock("") ==> 0

	
	// DONE
	public int superBlock(String input) {
		int highestCount = 0;
		
		int currentCount = 0;
		
		String lastVal = "";
		
		if (input.length() == 0) { return 0; }
		
		// Loop through each letter
		for(int i = 0; i < input.length(); i++) {
			//Each value
			String currentVal = input.substring(i, i + 1);
			
			//If it is the first value
			if(i == 0) {
				// Make last val equal to this
				lastVal = currentVal;
				
				// Add to count
				currentCount++;
				
				//If this is the highest value overall so far
				if (currentCount > highestCount) {
					highestCount = currentCount;
				}
				
			} else { // If this isn't the first value
				
				//If current value is same as last
				if(currentVal.equals(lastVal)) {
					currentCount++;
					
					//If this is the highest value overall so far
					if (currentCount > highestCount) {
						highestCount = currentCount;
					}
					
				} else { // Current value is not same as last
					currentCount = 0; // Reset current count
					currentCount++;
					lastVal = currentVal;
					
				}
			}
			
			
		}
		
		//System.out.println(highestCount);
		return highestCount;

	}
	
	//given a string - return the number of times "am" appears in the String ignoring case -
	// BUT ONLY WHEN the word "am" appears without being followed or proceeded by other letters
	//
	//amISearch("Am I in Amsterdam") ==> 1
	//amISearch("I am in Amsterdam am I?") ==> 2
	//amISearch("I have been in Amsterdam") ==> 0
	
	//DONE
	public int amISearch(String arg1) {
		
		int amCount = 0;
		
		//every space check for "am"
		
		
		//Loop through each letter check in twos, stop at 2nd to last item
		for(int i = 0; i < arg1.length()-1; i++) {
			// current 2 values!
			String currentVal = arg1.substring(i, i+2).toLowerCase();
			
			
			// If current value is am
			if(currentVal.equals("am")) {
				
				boolean lastVal = false;
				boolean nextVal = false;
				
				//check last value
				if(i == 0) { //if current value is index 0, we can safely assume there are no values before. 
					lastVal = true;
				} else if (arg1.substring(i-1, i).toLowerCase().equals(" ")) { //Alternatively if this isn't the first index, if the last item was " " then we are also good
					lastVal = true;
				} else { continue; } //if neither of these, then we know the value is invalid and we skip the rest of this iteration
				
				//check next value
				if(i == arg1.length()-1) { //if we are at the last possible position, then nextVal = true; (as nothing follows it)
					nextVal = true;
				} else if(arg1.substring(i+2, i+3).toLowerCase().equals(" ")) { //alternatively if the next value is a " " then we are also good
					nextVal = true;
				}
				
				// if nextVal and lastVal are true, then we can add this to the count!
				if(nextVal && lastVal) {
					amCount++;
				}
				
			}
			
		}
		return amCount;
	}
	
	//given a number 
	// if this number is divisible by 3 return "fizz"
	// if this number is divisible by 5 return "buzz"
	// if this number is divisible by both 3  and 5return "fizzbuzz"
	//
	//fizzBuzz(3) ==> "fizz"
	//fizzBuzz(10) ==> "buzz"
	//fizzBuzz(15) ==> "fizzbuzz"
	
	// DONE
	public String fizzBuzz(int arg1) {
		boolean fizz = arg1%3 == 0;
		boolean buzz = arg1%5 == 0;
		
		if(fizz && buzz) {
			return "fizzbuzz";
		} else if (fizz) {
			return "fizz";
		} else if (buzz) {
			return "buzz";
		}
		
		return null;
		
	}
	
	//Given a string split the string into the individual numbers present
	//then add each digit of each number to get a final value for each number
	// String example = "55 72 86"
	//
	// "55" will = the integer 10
	// "72" will = the integer 9
	// "86" will = the integer 14
	//
	// You then need to return the highest vale
	//
	//largest("55 72 86") ==> 14
	//largest("15 72 80 164") ==> 11
	//largest("555 72 86 45 10") ==> 15
	
	//DONE
	public int largest(String arg1) {
		
		ArrayList<Integer> totals = new ArrayList<Integer>();
		
		String[] sArray = arg1.split(" ");
		
		//Get me into the first array item
		for(int i = 0; i < sArray.length; i++) {
			int total = 0;
			
			//Each item in sArray
			String number = sArray[i];
			
			// Get me the first character in this string
			for(int x = 0; x < number.length(); x++) {
				String digit = number.substring(x, x + 1);
				total += Integer.parseInt(digit);
			}
			
			totals.add(total);
		}
		
		// Return the largest number
		int highestValue = 0;
		
		for(int no : totals) {
			if(no > highestValue) {
				highestValue = no;
			}
		}
		return highestValue;
	}
}
