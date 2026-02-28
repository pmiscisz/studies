cmake_minimum_required(VERSION 3.5)

project(kolM LANGUAGES C)

add_executable(kolM main.c)

install(TARGETS kolM
    LIBRARY DESTINATION ${CMAKE_INSTALL_LIBDIR})
