//suh du

//Challenge 1:
//C
int* DeleteDuplicates(int* nums, int length) {
  int checkIndex = 1;

  for(int i = 0; i < length; i++) {
    while(nums[checkIndex] == nums[i - 1] && checkIndex < length)
      checkIndex++;
    if(checkIndex >= length)
      nums[i] = 0;
    else
      nums[i] = nums[checkIndex];
  }

  return nums;
}

//tester
int main() {
  int length = 16;
  int nums[16] = { 1, 1, 2, 2, 2, 4, 4, 5, 6, 6, 6, 6, 7, 8, 8, 9 };

	DeleteDuplicates(nums, length);

	for(int i = 0; i < length; i++)
  	printf("%d ", nums[i]);
  return 0;
}

//Challenge 2:
//C++
vector<int> EnumeratePrimes(int n) {
  vector<int> primes;
  bool isPrime;

  if(n >= 2) {
    primes.push_back(2);
    for(int i = 3; i <= n; i++) {
    	isPrime = true;
    	for(int j = 0; j < primes.size() && (primes[j] * primes[j] < i); j++)
    		if(i % primes[j] == 0)
    			isPrime = false;
    	if(isPrime)
    		primes.push_back(i);
    }
  }

  return primes;
}

//tester
int main() {
	vector<int> primes;
	primes = EnumeratePrimes(100);

	for(int i = 0; i < primes.size(); i++)
		cout << primes[i] << " ";

	return 0;
}

//Challenge 3:
//C++
vector<int> SpiralOrder(vector<vector<int>> matrix, int r, int c) {
  int x = 0;
  int y = 0;
  int maxX = c;
  int maxY = r;
  int minX = -1;
  int minY = 0;
  vector<int> nums;
  for(int i = 0; i < (r * c); i++) {
    nums.push_back(matrix[y][x]);
    if(y == minY) {
      if(x < maxX - 1)
        x++;
      else if(x == maxX - 1) {
        maxX--;
        y++;
      }
    } else if(x == maxX) {
      if(y < maxY - 1)
        y++;
      else if(y == maxY - 1) {
        maxY--;
        x--;
      }
    } else if(y == maxY) {
      if(x > minX + 1)
        x--;
      else if(x == minX + 1) {
        minX++;
        y--;
      }
    } else if(x == minX) {
      if(y > minY + 1)
        y--;
      else if(y == minY + 1) {
        minY++;
        x++;
      }
    }
  }

  return nums;
}

//tester
int main(void) {
    vector<vector<int>> mat;
    vector<int> temp;
    temp.push_back(1);
    temp.push_back(2);
    temp.push_back(3);
    temp.push_back(4);
    mat.push_back(temp);
    temp.clear();
    temp.push_back(5);
    temp.push_back(6);
    temp.push_back(7);
    temp.push_back(8);
    mat.push_back(temp);
    temp.clear();
    temp.push_back(9);
    temp.push_back(10);
    temp.push_back(11);
    temp.push_back(12);
    mat.push_back(temp);
    temp.clear();

    vector<int> nums = SpiralOrder(mat, 3, 4);

    for(int i = 0; i < 12; i++) {
      cout << nums[i] << " ";
    }
    return 0;
}

//Challenge 4:
//C
int isPalindrome(char* str, int length) {
  int front = 0;
  int back = length - 1;
  while(front <= back) {
    while(!isalpha(str[front]))
      front++;
    while(!isalpha(str[back]))
      back--;
    if(tolower(str[front]) != tolower())str[back]))
      return 0;
    front++;
    back--;
  }
  return 1;
}

//tester
int main(void) {
    char* string = "race a car";

    printf("%d", isPalindrome(string, 10));
    return 0;
}

//Challenge 5
//C++
string LPS(string s) {
  for (let length = s.size(); length > 1; length--) {
		let offset = 0;
		while (offset + length <= s.size()) {
			let substring = s.substr(offset, length);
			if (isPalindrome(substring))
				return substring;
			offset++;
		}
	}
	return s[0];
}

bool isPalindrome(string s) {
	for (let i = 0; i < s.size()/2; i++)
		if (characters[i] != characters[s.size() - i - 1])
			return false;
	return true;
}

//Challenge 6
//C++
string LCP(string* s, int length) {
  string prefix = "";
  int currIndex = 0;
  char currChar;
  bool append;

  while(append) {
    append = true;
    for(int i = 0; i < length; i++)
      if(currIndex == s[i].size() || s[i][currIndex] != s[0][currIndex])
        append = false;
    if(append)
      prefix.push_back(s[0][currIndex]);
    currIndex++;
  }

  return prefix;
}

int main() {
  string s[3] = { "bceefgh", "bcfghijk", "bcefgh" };
  string prefix = LCP(s, 3);

  cout << prefix;
  return 1;
}

//Interview #1 - Gold Stars
//C++
int GoldStars(vector<int> ratings) {
  vector<int> stars(ratings.size(), 1);
  int totalStars = ratings.size();

  for(int i = 0; i < ratings.size() - 1; i++)
    if(ratings[i+1] > ratings[i] && stars[i+1] <= stars[i]) {
      totalStars += stars[i] + 1 - stars[i+1];
      stars[i+1] = stars[i] + 1;
    }

  for(int i = ratings.size() - 1; i > 0; i--)
    if(ratings[i-1] > ratings[i] && stars[i-1] <= stars[i]) {
      totalStars += stars[i] + 1 - stars[i-1];
      stars[i-1] = stars[i] + 1;
    }

  return totalStars;
}

//W/ bonus
int GoldStars(vector<int> ratings) {
  vector<int> stars(ratings.size(), 1);
  int totalStars = ratings.size();

  for(int i = 0; i < ratings.size() - 1; i++)
    if(ratings[i+1] >= ratings[i] && stars[i+1] <= stars[i]) {
      if(ratings[i+1] == ratings[i]) {
        totalStars += stars[i] - stars[i+1];
        stars[i+1] = stars[i];
      } else {
        totalStars += stars[i] + 1 - stars[i+1];
        stars[i+1] = stars[i] + 1;
      }
    }

  for(int i = ratings.size() - 1; i > 0; i--)
    if(ratings[i-1] >= ratings[i] && stars[i-1] <= stars[i]) {
      if(ratings[i-1] == ratings[i]) {
        totalStars += stars[i] - stars[i-1];
        stars[i-1] = stars[i];
      } else {
        totalStars += stars[i] + 1 - stars[i-1];
        stars[i-1] = stars[i] + 1;
      }
    }

  return totalStars;
}

//tester
int main() {
	vector<int> ratings;
	ratings.push_back(1);
	ratings.push_back(2);
	ratings.push_back(2);

	cout << GoldStars(ratings);
	return 0;
}
