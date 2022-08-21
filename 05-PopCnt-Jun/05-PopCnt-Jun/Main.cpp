#include <iostream>
#include "PopCntSimple.h"
#include "PopCntMinus.h"

int main() {
	int num = 12599488;
	int ret1 = PopCntSimple().Exec(num);
	int ret2 = PopCntMinus().Exec(num);

	std::cout << "Num: " << num << " PopCntSimple: " << ret1 <<  " PopCntMinus: " << ret2 << std::endl;

	return 0;
}