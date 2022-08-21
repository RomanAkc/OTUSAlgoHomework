#include "PopCntMinus.h"

int PopCntMinus::Exec(unsigned long long num) {
    int cnt = 0;
	while(num > 0) {
		cnt++;
		num &= num - 1;
	}
    return cnt;
}
