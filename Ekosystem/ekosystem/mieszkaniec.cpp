

#include "Mieszkaniec.h"

Mieszkaniec::Mieszkaniec(char _symbol) {
    symbol = _symbol;
}

Mieszkaniec::Mieszkaniec(const Mieszkaniec &mieszkaniec) {
    symbol = mieszkaniec.jakiSymbol();
}

char Mieszkaniec::jakiSymbol() const {
    return symbol;
}

Mieszkaniec::~Mieszkaniec() {

}
