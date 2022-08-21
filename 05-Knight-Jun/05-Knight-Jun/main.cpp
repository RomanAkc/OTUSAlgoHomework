#include "func.h"
#include <iostream>

int main() {
	int arr[] = {0, 1, 2, 36, 47, 48, 54, 55, 56, 63};

	for(auto pos : arr) {
		auto [counter, mask] = getKnightMask(pos);
		std::cout << pos << std::endl << counter << std::endl << mask << std::endl << std::endl;
	}

	return 0;
}