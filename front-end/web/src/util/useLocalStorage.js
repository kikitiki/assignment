import { useEffect } from "react";
import { useState } from "react";

function useLocalState(defaultValue, key) {
  const [value, setValue] = useState(() => {
    const localStorageValue = localStorage.getItem(key);
    console.log(`localStorageValue ${key} is ${localStorageValue}`);

    return localStorageValue !== null
      ? JSON.parse(localStorageValue)
      : defaultValue;
  });

  useEffect(() => {
    localStorage.setItem(key, JSON.stringify(value));
    console.log(`updating local storage ${key} to ${value}`);
  }, [key, value]);

  return [value, setValue];
}

export { useLocalState };
