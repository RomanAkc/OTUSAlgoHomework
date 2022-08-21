#pragma once
#include <utility>

std::pair<int, unsigned long long> getKnightMask(int pos);
unsigned long long nextPosition(int& counter, unsigned long long num, int cntBits, bool bLeft);