import * as React from 'react';

import { StyleSheet, View, Button } from 'react-native';
import bitlabs from 'react-native-bitlabs';

export default function App() {
  return (
    <View style={styles.container}>
      <Button title="Start Bitlabs" onPress={() => bitlabs.show()} />

      <Button
        title="hasSurveys"
        onPress={() => {
          bitlabs.init('', '');
          bitlabs
            .hasSurveys()
            .then((value) => {
              console.log('tem pesquisa ' + value);
            })
            .catch((error) => {
              console.log(error);
            });
        }}
      />
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
  },
  box: {
    width: 60,
    height: 60,
    marginVertical: 20,
  },
});
