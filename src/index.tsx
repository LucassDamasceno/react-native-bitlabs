import { NativeModules, Platform } from 'react-native';

const LINKING_ERROR =
  `The package 'react-native-bitlabs' doesn't seem to be linked. Make sure: \n\n` +
  Platform.select({ ios: "- You have run 'pod install'\n", default: '' }) +
  '- You rebuilt the app after installing the package\n' +
  '- You are not using Expo managed workflow\n';

const Bitlabs = NativeModules.Bitlabs
  ? NativeModules.Bitlabs
  : new Proxy(
      {},
      {
        get() {
          throw new Error(LINKING_ERROR);
        },
      }
    );

function show(): void {
  return Bitlabs.show();
}
function hasSurveys(): Promise<boolean> {
  return Bitlabs.hasSurveys();
}

function init(
  token: string,
  userId: string,
  playerId: string
): Promise<boolean> {
  return Bitlabs.initBitLabsSDK(token, userId, playerId);
}

export default { show, hasSurveys, init };
