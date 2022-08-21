#include "func.h"

std::pair<int, unsigned long long> getKingMask(int pos) {
	unsigned long long K = 1i64 << pos;
	auto Ka = K & 0xfefefefefefefefe;
	auto Kh = K & 0x7f7f7f7f7f7f7f7f;
	int counter = 0;

	unsigned long long mask = 0;

	mask += nextPosition(counter, Ka, 7, true);
	mask += nextPosition(counter, K, 8, true);
	mask += nextPosition(counter, Kh, 9, true);

	mask += nextPosition(counter, Ka, 1, false);
	mask += nextPosition(counter, Kh, 1, true);

	mask += nextPosition(counter, Ka, 9, false);
	mask += nextPosition(counter, K, 8, false);
	mask += nextPosition(counter, Kh, 7, false);

	return {counter, mask};
}

unsigned long long nextPosition(int& counter, unsigned long long num, int cntBits, bool bLeft) {
	unsigned long long tmp = 0;

	if(bLeft)
		tmp |= (num << cntBits);
	else
		tmp |= (num >> cntBits);

	if(tmp != 0)
		counter++;

	return tmp;
}
