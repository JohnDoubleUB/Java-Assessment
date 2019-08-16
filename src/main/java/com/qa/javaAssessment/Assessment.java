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

	public String getBert(String input) {
		
		return "";
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

	public boolean evenlySpaced(int a, int b, int c) {
		// I miss read the task... 
		
		// check the spaceing of each value against the other two values
		// check which value is bigger
		int current1 = 0;
		int current2 = 0;
		int intCase = 0;
		int calc = 0;
		
		int[] values = {a, b, c};
		
		
		for(int i = 0; i < values.length; i++) {
			// Get first value
			current1 = values[i];
			
			for (int x = 0; x < values.length; x++) {
				
				// Ensure there are no comparisons to itself by skipping these
				if(x == i) { continue; }
				
				// Get second value
				current2 = values[x];
				
				//Establish first case!
				
				// if this is the first value in both indexes (The first loop of each (Excluding skip))
				if(i == 0 && x == 1) {
					
					// if current 1 is less, take this away from the larger one
					if (current1 < current2) {
						intCase = current2 - current1;
					} else { // if current 2 is less then take it away from the larger one
						intCase = current1 - current2;
					}
					
					System.out.println(intCase);
					
				} else { // The current value is not the first one!
					
					if (current1 < current2) {
						System.out.println(current2 +  "-" + current1 + "=" + (current2 - current1));
						calc = current2 - current1;
						if (intCase != calc) {
							return false;
						}
						
						
					} else { // if current 2 is less then take it away from the larger one
						System.out.println(current1 +  "-" + current2 + "=" + (current1 - current2));
						calc = current1 - current2;
						if (intCase != calc) {
							return false;
						}
					}
				}
				
				
			}
		}
		
		return true;
	}

	// Given a string and an int n, return a string that removes n letters from the 'middle' of the string.
	// The string length will be at least n, and be odd when the length of the input is odd.

	// nMid("Hello", 3) ==> "Ho"
	// nMid("Chocolate", 3) ==> "Choate"
	// nMid("Chocolate", 1) ==> "Choclate"

	public String nMid(String input, int a) {
		
		
		return "";
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

	public int amISearch(String arg1) {
		
		boolean foundA = false;
		
		String lastVal = "";
		String currentVal = "";
		String nextVal = "";
		
		boolean lastIndex = false;
		
		int amCount = 0;
		
		for(int i = 0; i < arg1.length(); i++) {
			
			//Store current value
			currentVal =  arg1.substring(i, i + 1);
			
			//Last index?
			lastIndex = i == arg1.length();
			
			//provided we are not at the last index
			if(!lastIndex) {
				nextVal = arg1.substring(i + 1, i + 2);
			}
			
			// If first iteration we can't do anything
//			if(i == 0) {
//				lastVal = currentVal;
//			}
			
			// If current value is an a
			if (currentVal.equals("a")) {
				foundA = true;
				// Don't set last value if its a!
				
				
			} else if (currentVal.equals("m") && foundA) { // if current value is a b AND last a was just seen
				// We have found am!
				
				// Check surroundings
				if(lastVal.equals(" ") && (lastIndex | nextVal.equals(" "))) {
					amCount++;
				}
				
				foundA = false;
				lastVal = currentVal;
				
				
			} else {// if the current value is neither
				foundA = false;
				lastVal = currentVal;
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
		
		
		for(int i = 0; i < sArray.length; i++) {
			int total = 0;
			//Each item in sArray
			String number = sArray[i];
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
