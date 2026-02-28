TEMPLATE = app
CONFIG += console c++17
CONFIG -= app_bundle
CONFIG -= qt

BOOST_ROOT = C:/Users/Patryk/Desktop/szkoła/boost_1_86_0/boost_1_86_0  # Upewnij się, że to jest poprawna ścieżka
#BOOST_ROOT = C:/libraries/Addon_CPP_Libraries/boost_1_86_0
INCLUDEPATH += $$BOOST_ROOT
LIBS += -L$$BOOST_ROOT/stage/lib

SOURCES += \
        main.cpp \
        person.cpp

HEADERS += \
    person.h
