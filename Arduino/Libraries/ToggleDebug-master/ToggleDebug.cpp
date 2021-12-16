#include <ToggleDebug.h>

ToggleDebug::ToggleDebug(int delay)
{
    _delay = delay; //Initialize debugPrint delay
}

void ToggleDebug::debugPrint(String message) //Print debug message every x milliseconds
{
    if (millis() - _timer >= _delay)
    {
        _timer = millis();
        Serial.println(message + "\n");
    }
}

int getMemory()
{
    extern unsigned int __heap_start;
    extern void *__brkval;
    int v;
    int freeMemory = (int)&v - (__brkval == 0 ? (int)&__heap_start : (int)__brkval);

    return freeMemory;
}

bool ToggleDebug::getAvailableMemory(String file, String method, int line, bool extraInfo) //Get available RAM memory between stack and heap. Returns true if change is detected
{
    bool error = false;
    if (millis() - _timer >= _delay)
    {
        _timer = millis();

        if (_prevMem != getMemory() && _prevMem > 0)
        {
            Serial.println("Memory changed!");
            Serial.println("Previous free memory was " + String(_prevMem));
            error = true;
        }

        if(extraInfo)
        {
            Serial.println(String(millis()) + ": " + file + " " + method + " line:" + line +  " Memory free: " + String(getMemory()) + " bytes");
        }
        else
        {
            Serial.println("Memory free: " + String(getMemory()) + " bytes");
        }

        _prevMem = getMemory();
    }
    return error;
}

int printMem(String extraInfo)
{
    Serial.println(extraInfo + "Memory free: " + String(getMemory()) + " bytes");
    return getMemory();
}
