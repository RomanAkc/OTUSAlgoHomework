#include "func.h"

std::pair<int, unsigned long long> getKnightMask(int pos) {
	unsigned long long K = 1i64 << pos;

	auto Ka = K & 0xfefefefefefefefe;
	auto Kab = K & 0xfcfcfcfcfcfcfcfc;
	auto Kh = K & 0x7f7f7f7f7f7f7f7f;
	auto Kgh = K & 0x3f3f3f3f3f3f3f3f;

	int counter = 0;
	unsigned long long mask = 0;

	mask |= nextPosition(counter, Ka, 15, true);
	mask |= nextPosition(counter, Ka, 17, false);

	mask |= nextPosition(counter, Kab, 6, true);
	mask |= nextPosition(counter, Kab, 10, false);

	mask |= nextPosition(counter, Kgh, 10, true);
	mask |= nextPosition(counter, Kgh, 6, false);

	mask |= nextPosition(counter, Kh, 17, true);
	mask |= nextPosition(counter, Kh, 15, false);

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