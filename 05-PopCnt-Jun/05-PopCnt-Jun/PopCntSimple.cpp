#include "PopCntSimple.h"

int PopCntSimple::Exec(unsigned long long num) {
	int cnt = 0;

	for(int i = 0; i < 64; ++i) {
		if((num & 1i64) == 1)
			cnt++;
		num >>= 1;
	}

	return cnt;
}
