#include "func.h"
#include <iostream>

int main() {	
	int arr[] = {0, 1, 7, 8, 10, 15, 54, 55, 56, 63};

	for(auto pos : arr) {
		auto [counter, mask] = getKingMask(pos);
		std::cout << pos << std::endl << counter << std::endl << mask << std::endl << std::endl;
	}

	return 0;
}

